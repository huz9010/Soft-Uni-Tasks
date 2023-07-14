package com.example.springdataintro.services.interfaces;

import com.example.springdataintro.enitities.Book;
import com.example.springdataintro.enums.AgeRestriction;
import com.example.springdataintro.enums.EditionType;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<String> getAllBookTitlesByAgeRestriction(AgeRestriction ageRestriction);

    List<String> getAllGoldenEditionBooksWithLessThanCopies(EditionType editionType, Integer copies);

    List<String> getAllBooksWithPriceLowerThanAndHigherThan(BigDecimal lower, BigDecimal upper);

    List<String> getAllBookTitlesNotReleasedInYear(int year);

    List<String> getAllBooksReleasedAfterDate(LocalDate date);

    List<String> getAllBookTitlesContaining(String str);

    List<String> getAllBooksAuthorsLastNameStartsWith(String str);

    int getCountOfBooksWithTitleLongerThan(int length);

    String getBookInfoByTitle(String title);
}
