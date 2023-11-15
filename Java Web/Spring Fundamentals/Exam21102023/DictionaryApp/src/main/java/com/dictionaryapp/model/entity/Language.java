package com.dictionaryapp.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "languages")
public class Language extends BaseEntity {

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private LanguageEnum name;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "language")
    private List<Word> words;

    public Language() {
    }

    public LanguageEnum getName() {
        return name;
    }

    public void setName(LanguageEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }
}
