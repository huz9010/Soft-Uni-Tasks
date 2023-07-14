package com.example.springdataintro.repositories;

import com.example.springdataintro.enitities.Book;
import com.example.springdataintro.enums.AgeRestriction;
import com.example.springdataintro.enums.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByAgeRestrictionEquals(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType,Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal lower, BigDecimal upper);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate before, LocalDate after);

    List<Book> findAllByReleaseDateBefore(LocalDate date);

    List<Book> findAllByTitleContaining(String str);

    List<Book> findAllByAuthorLastNameStartsWith(String str);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :length")
    int countAllByTitleIsLongerThan(@Param(value = "length") int length);

    List<Book> findAllByTitleEquals(String title);
}
