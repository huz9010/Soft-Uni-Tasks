package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;

public interface LanguageService {

    Language findByLanguage(LanguageEnum language);
}
