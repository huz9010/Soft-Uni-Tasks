package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ConstellationImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.service.ConstellationService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static softuni.exam.constants.PathsAndFiles.CONSTELLATIONS_IMPORT;
import static softuni.exam.constants.PathsAndFiles.JSON_IMPORT_PATH;
import static softuni.exam.constants.messages.Messages.*;

@Service
public class ConstellationServiceImpl implements ConstellationService {

    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public ConstellationServiceImpl(ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return constellationRepository.count() > 0;
    }

    @Override
    public String readConstellationsFromFile() throws IOException {
        return Files.readString(Path.of(JSON_IMPORT_PATH + CONSTELLATIONS_IMPORT));
    }

    @Override
    public String importConstellations() throws IOException {

        StringBuilder sb = new StringBuilder();

        ConstellationImportDto[] constellations = gson.fromJson(readConstellationsFromFile(), ConstellationImportDto[].class);

        for (ConstellationImportDto constellation : constellations) {
            sb.append(System.lineSeparator());
            if (constellationRepository.findFirstByName(constellation.getName()).isPresent() || !validationUtil.isValid(constellation)) {
                sb.append(INVALID_CONSTELLATION);
                continue;
            }

            constellationRepository.save(modelMapper.map(constellation, Constellation.class));
            sb.append(SUCCESSFULLY_IMPORTED).append(CONSTELLATION).append(String.format(CONSTELLATION_FORMAT, constellation.getName(), constellation.getDescription()));
        }

        return sb.toString().trim();
    }
}
