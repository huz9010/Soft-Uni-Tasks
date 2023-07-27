package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.MechanicImportDto;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Mechanic;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.MechanicsRepository;
import softuni.exam.service.MechanicsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static softuni.exam.constants.messages.Messages.*;
import static softuni.exam.constants.messages.Messages.PART_FORMAT;
import static softuni.exam.constants.messages.PathsAndFiles.JSON_IMPORT_PATH;
import static softuni.exam.constants.messages.PathsAndFiles.MECHANICS_IMPORT;

@Service
public class MechanicsServiceImpl implements MechanicsService {

    private final MechanicsRepository mechanicsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public MechanicsServiceImpl(MechanicsRepository mechanicsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.mechanicsRepository = mechanicsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return mechanicsRepository.count() > 0;
    }

    @Override
    public String readMechanicsFromFile() throws IOException {
        return Files.readString(Path.of(JSON_IMPORT_PATH + MECHANICS_IMPORT));
    }

    @Override
    public String importMechanics() throws IOException {
        final StringBuilder sb = new StringBuilder();

        MechanicImportDto[] mechanicImportDtos = gson.fromJson(readMechanicsFromFile(), MechanicImportDto[].class);

        for (MechanicImportDto mechanic : mechanicImportDtos) {
            sb.append(System.lineSeparator());
            if (mechanicsRepository.findFirstByEmail(mechanic.getEmail()).isPresent()
                    || mechanicsRepository.findFirstByPhone(mechanic.getPhone()).isPresent()
                    || mechanicsRepository.findFirstByFirstName(mechanic.getFirstName()).isPresent()
                    || !validationUtil.isValid(mechanic)) {
                sb.append(INVALID_MECHANIC);
                continue;
            }

            mechanicsRepository.save(modelMapper.map(mechanic, Mechanic.class));
            sb.append(SUCCESSFULLY_IMPORTED).append(MECHANIC).append(String.format(MECHANIC_FORMAT, mechanic.getFirstName(), mechanic.getLastName()));
        }

        return sb.toString().trim();
    }
}
