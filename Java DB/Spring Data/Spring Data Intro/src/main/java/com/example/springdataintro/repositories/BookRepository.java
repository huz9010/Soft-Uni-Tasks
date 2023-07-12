package com.example.springdataintro.repositories;

import com.example.springdataintro.enitities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findBooksByReleaseDateAfter(LocalDate dateAfter);

    List<Book> findBookByReleaseDateBefore(LocalDate localDate);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String firstName, String lastName);
}
