package com.dictionaryapp.model.binding;

import com.dictionaryapp.model.entity.LanguageEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class WordCreateBindingModel {

    private Long id;

    @NotNull
    @Size(min = 2, max = 40)
    private String term;

    @NotNull
    @Size(min = 2, max = 80)
    private String translation;

    @Size(min = 2, max = 200)
    private String example;

    @NotNull
    @PastOrPresent
    private LocalDate inputDate;

    @NotNull
    private LanguageEnum language;

    public WordCreateBindingModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEnum language) {
        this.language = language;
    }
}
