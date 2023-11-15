package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.model.view.WordViewModel;

import java.util.Collection;

public interface WordService {
    void addWord(WordServiceModel word, UserServiceModel user);

    Collection<WordViewModel> getAllWordsByLanguage(LanguageEnum language);

    void removeAllWords();

    void removeWordById(Long id);
}
