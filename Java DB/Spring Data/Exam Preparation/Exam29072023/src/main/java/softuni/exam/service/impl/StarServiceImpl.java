package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.constants.enumeration.StarType;
import softuni.exam.models.dto.StarExportDto;
import softuni.exam.models.dto.StarImportDto;
import softuni.exam.models.entity.Constellation;
import softuni.exam.models.entity.Star;
import softuni.exam.repository.ConstellationRepository;
import softuni.exam.repository.StarRepository;
import softuni.exam.service.StarService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import java.util.stream.Collectors;

import static softuni.exam.constants.PathsAndFiles.JSON_IMPORT_PATH;
import static softuni.exam.constants.PathsAndFiles.STARS_IMPORT;
import static softuni.exam.constants.messages.Messages.*;

@Service
public class StarServiceImpl implements StarService {

    private final StarRepository starRepository;
    private final ConstellationRepository constellationRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StarServiceImpl(StarRepository starRepository, ConstellationRepository constellationRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.starRepository = starRepository;
        this.constellationRepository = constellationRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return starRepository.count() > 0;
    }

    @Override
    public String readStarsFileContent() throws IOException {
        return Files.readString(Path.of(JSON_IMPORT_PATH + STARS_IMPORT));
    }

    @Override
    public String importStars() throws IOException {

        StringBuilder sb = new StringBuilder();

        StarImportDto[] stars = gson.fromJson(readStarsFileContent(), StarImportDto[].class);

        for (StarImportDto star : stars) {
            sb.append(System.lineSeparator());
            Optional<Constellation> constellation = constellationRepository.findFirstById(star.getConstellation());

            if (constellation.isEmpty() || starRepository.findFirstByName(star.getName()).isPresent() || !validationUtil.isValid(star)) {
                sb.append(INVALID_STAR);
                continue;
            }

            Star starToSave = modelMapper.map(star, Star.class);
            starToSave.setConstellation(constellation.get());

            starRepository.save(starToSave);
            sb.append(SUCCESSFULLY_IMPORTED).append(STAR).append(String.format(STAR_FORMAT, star.getName(), star.getLightYears()));
        }

        return sb.toString().trim();
    }

    @Override
    public String exportStars() {
        return starRepository.findAllByStarTypeAndObserversEmptyOrderByLightYears(StarType.RED_GIANT)
                .stream().map(star -> modelMapper.map(star, StarExportDto.class))
                .map(StarExportDto::toString).collect(Collectors.joining());
    }
}
