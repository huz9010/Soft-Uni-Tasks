package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CarImportDto;
import softuni.exam.models.dto.CarImportRootDto;
import softuni.exam.models.entity.Car;
import softuni.exam.repository.CarsRepository;
import softuni.exam.service.CarsService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static softuni.exam.constants.messages.Messages.*;

@Service
public class CarsServiceImpl implements CarsService {
    private static String CARS_FILE_PATH = "src/main/resources/files/xml/cars.xml";

    private final CarsRepository carsRepository;
    private final XMLParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public CarsServiceImpl(CarsRepository carsRepository, XMLParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.carsRepository = carsRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return carsRepository.count() > 0;
    }

    @Override
    public String readCarsFromFile() throws IOException {
        return Files.readString(Path.of(CARS_FILE_PATH));
    }

    @Override
    public String importCars() throws IOException, JAXBException {
        final StringBuilder sb = new StringBuilder();

        final List<CarImportDto> cars = xmlParser.readFromXml(CARS_FILE_PATH, CarImportRootDto.class).getCars();

        for (CarImportDto car : cars) {
            sb.append(System.lineSeparator());

            if (carsRepository.findFirstByPlateNumber(car.getPlateNumber()).isPresent() || !validationUtil.isValid(car)) {
                sb.append(INVALID_CAR);
                continue;
            }

            carsRepository.save(modelMapper.map(car, Car.class));

            sb.append(SUCCESSFULLY_IMPORTED).append(CAR).append(String.format(CAR_FORMAT, car.getCarMake(), car.getCarModel()));
        }

        return sb.toString().trim();
    }
}
