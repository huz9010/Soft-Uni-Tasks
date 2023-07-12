package com.example.springdataintro.services.interfaces;

import com.example.springdataintro.enitities.Author;
import com.example.springdataintro.enitities.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {

    void seedBooks() throws IOException;

    List<Book> findBooksByReleaseDateAfter(int year);

    List<String> findAllAuthorsWithBookReleaseDateBefore(int year);

    List<String> findAllBooksByAuthorFullNameOrderByReleaseDateDescTitle(String firstName, String lastName);
}
