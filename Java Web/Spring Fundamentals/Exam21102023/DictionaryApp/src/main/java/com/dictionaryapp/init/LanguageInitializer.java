package com.dictionaryapp.init;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageDescriptions;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.repo.LanguageRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class LanguageInitializer implements CommandLineRunner {

    private final LanguageRepository languageRepository;

    public LanguageInitializer(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.languageRepository.count() == 0) {
            List<Language> languages = Arrays.stream(LanguageEnum.values())
                    .map(e -> {
                        Language language = new Language();
                        language.setName(e);
                        switch (e.name()) {
                            case "GERMAN" -> language.setDescription(LanguageDescriptions.GERMAN);
                            case "SPANISH" -> language.setDescription(LanguageDescriptions.SPANISH);
                            case "FRENCH" -> language.setDescription(LanguageDescriptions.FRENCH);
                            case "ITALIAN" -> language.setDescription(LanguageDescriptions.ITALIAN);
                        }
                        return language;
                    })
                    .toList();

            this.languageRepository.saveAll(languages);
        }
    }
}
