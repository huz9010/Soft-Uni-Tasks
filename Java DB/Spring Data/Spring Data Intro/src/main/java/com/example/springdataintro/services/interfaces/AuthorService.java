package com.example.springdataintro.services.interfaces;

import com.example.springdataintro.enitities.Author;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.util.List;

public interface AuthorService {

    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    @Query("SELECT a FROM Author a ORDER BY a.books.size DESC")
    List<String> getAllAuthorsByNumberOfBooksDesc();
}
