package com.example.springdataintro.repositories;

import com.example.springdataintro.enitities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    List<Author> findAllByFirstNameEndingWith(String str);

    @Query("SELECT CONCAT(a.firstName, ' ', a.lastName), (SELECT SUM(b.copies) FROM Book b WHERE b.author = a ) AS s FROM Author a ORDER BY s DESC")
    List<Object[]> findAuthorsWithCopiesOfTheirBooks();
}
