package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.entity.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

    Collection<Word> findAllByLanguageName(LanguageEnum language);
}
