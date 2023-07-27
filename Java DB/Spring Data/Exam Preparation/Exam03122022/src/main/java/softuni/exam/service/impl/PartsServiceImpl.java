package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.PartImportDto;
import softuni.exam.models.entity.Part;
import softuni.exam.repository.PartsRepository;
import softuni.exam.service.PartsService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static softuni.exam.constants.messages.Messages.*;
import static softuni.exam.constants.messages.PathsAndFiles.JSON_IMPORT_PATH;
import static softuni.exam.constants.messages.PathsAndFiles.PARTS_IMPORT;

@Service
public class PartsServiceImpl implements PartsService {

    private final PartsRepository partsRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PartsServiceImpl(PartsRepository partsRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.partsRepository = partsRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return partsRepository.count() > 0;
    }

    @Override
    public String readPartsFileContent() throws IOException {
        return Files.readString(Path.of(JSON_IMPORT_PATH + PARTS_IMPORT));
    }

    @Override
    public String importParts() throws IOException {
        final StringBuilder sb = new StringBuilder();

        PartImportDto[] partImportDtos = gson.fromJson(readPartsFileContent(), PartImportDto[].class);
        DecimalFormat df = new DecimalFormat("#.0#", new DecimalFormatSymbols(Locale.US));
        for (PartImportDto part : partImportDtos) {
            sb.append(System.lineSeparator());
            if (partsRepository.findFirstByPartName(part.getPartName()).isPresent() || !validationUtil.isValid(part)) {
                sb.append(INVALID_PART);
                continue;
            }

            partsRepository.save(modelMapper.map(part, Part.class));
            sb.append(SUCCESSFULLY_IMPORTED).append(PART).append(String.format(PART_FORMAT, part.getPartName(), df.format(part.getPrice())));
        }

        return sb.toString().trim();
    }
}
