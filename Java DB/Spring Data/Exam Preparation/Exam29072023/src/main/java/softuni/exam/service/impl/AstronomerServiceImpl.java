package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AstronomerImportDto;
import softuni.exam.models.dto.AstronomerImportRootDto;
import softuni.exam.models.entity.Astronomer;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.AstronomerRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.AstronomerService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XMLParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static softuni.exam.constants.PathsAndFiles.ASTRONOMERS_IMPORT;
import static softuni.exam.constants.PathsAndFiles.XML_IMPORT_PATH;
import static softuni.exam.constants.messages.Messages.*;

@Service
public class AstronomerServiceImpl implements AstronomerService {

    private final AstronomerRepository astronomerRepository;
    private final StarRepository starRepository;
    private final XMLParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public AstronomerServiceImpl(AstronomerRepository astronomerRepository, StarRepository starRepository, XMLParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.astronomerRepository = astronomerRepository;
        this.starRepository = starRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return astronomerRepository.count() > 0;
    }

    @Override
    public String readAstronomersFromFile() throws IOException {
        return Files.readString(Path.of(XML_IMPORT_PATH + ASTRONOMERS_IMPORT));
    }

    @Override
    public String importAstronomers() throws IOException, JAXBException {

        StringBuilder sb = new StringBuilder();

        List<AstronomerImportDto> astronomers = xmlParser.readFromXml(XML_IMPORT_PATH + ASTRONOMERS_IMPORT, AstronomerImportRootDto.class).getAstronomers();

        for (AstronomerImportDto astronomer : astronomers) {
            sb.append(System.lineSeparator());

            Optional<Star> star = starRepository.findFirstById(astronomer.getObservingStarId());
            Optional<Astronomer> astronomerToCheck = astronomerRepository.findFirstByFirstNameAndLastName(astronomer.getFirstName(), astronomer.getLastName());

            if (star.isEmpty() || astronomerToCheck.isPresent() || !validationUtil.isValid(astronomer)) {
                sb.append(INVALID_ASTRONOMER);
                continue;
            }

            Astronomer astronomerToSave = modelMapper.map(astronomer, Astronomer.class);
            astronomerToSave.setBirthday(LocalDate.parse(astronomer.getBirthday(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
            astronomerToSave.setObservingStar(star.get());

            astronomerRepository.save(astronomerToSave);
            sb.append(SUCCESSFULLY_IMPORTED).append(ASTRONOMER).append(String.format(ASTRONOMER_FORMAT,
                    astronomer.getFirstName(), astronomer.getLastName(), astronomer.getAverageObservationHours()));
        }

        return sb.toString().trim();
    }
}
