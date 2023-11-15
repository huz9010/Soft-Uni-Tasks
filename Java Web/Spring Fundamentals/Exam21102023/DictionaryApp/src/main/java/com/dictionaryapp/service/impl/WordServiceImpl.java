package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.Language;
import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.entity.Word;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.model.view.WordViewModel;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.LanguageService;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class WordServiceImpl implements WordService {

    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;
    private final UserService userService;
    private final LanguageService languageService;

    public WordServiceImpl(ModelMapper modelMapper, WordRepository wordRepository, UserService userService, LanguageService languageService) {
        this.modelMapper = modelMapper;
        this.wordRepository = wordRepository;
        this.userService = userService;
        this.languageService = languageService;
    }

    @Override
    public void addWord(WordServiceModel word, UserServiceModel user) {
        Word wordEntity = this.modelMapper.map(word, Word.class);
        User currentUser = this.userService.findById(user.getId());
        Language languageEntity = this.languageService.findByLanguage(word.getLanguage());

        wordEntity.setAddedBy(currentUser);
        wordEntity.setLanguage(languageEntity);

        this.wordRepository.save(wordEntity);
    }


    @Override
    public Collection<WordViewModel> getAllWordsByLanguage(LanguageEnum language) {
        return this.wordRepository.findAllByLanguageName(language).stream()
                .map(w -> {
                    WordViewModel word = this.modelMapper.map(w, WordViewModel.class);
                    UserServiceModel user = this.modelMapper.map(w.getAddedBy(), UserServiceModel.class);
                    word.setAddedBy(user.getUsername());
                    return word;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void removeAllWords() {
        this.wordRepository.deleteAll();
    }

    @Override
    public void removeWordById(Long id) {
        this.wordRepository.deleteById(id);
    }

}


