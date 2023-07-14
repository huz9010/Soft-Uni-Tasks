package com.example.springdataintro.services.interfaces;

import com.example.springdataintro.enitities.Author;

import java.io.IOException;
import java.util.List;


public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> getAllAuthorsNamesFirstNameEndingWith(String str);

    List<Object[]> getAuthorsWithTotalCopies();
}
