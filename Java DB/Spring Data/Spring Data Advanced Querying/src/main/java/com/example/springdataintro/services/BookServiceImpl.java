package com.example.springdataintro.services;

import com.example.springdataintro.enitities.Author;
import com.example.springdataintro.enitities.Book;
import com.example.springdataintro.enitities.Category;
import com.example.springdataintro.enums.AgeRestriction;
import com.example.springdataintro.enums.EditionType;
import com.example.springdataintro.repositories.BookRepository;
import com.example.springdataintro.services.interfaces.AuthorService;
import com.example.springdataintro.services.interfaces.BookService;
import com.example.springdataintro.services.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final String BOOKS_FILE_PATH = "src/main/resources/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }

    @Override
    public void seedBooks() throws IOException {
        if (bookRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(BOOKS_FILE_PATH))
                .forEach(row -> {
                    String[] bookData = row.split("\\s+");
                    Book book = createBook(bookData);
                    bookRepository.save(book);
                });
    }

    @Override
    public List<String> getAllBookTitlesByAgeRestriction(AgeRestriction ageRestriction) {
        return bookRepository.findAllByAgeRestrictionEquals(ageRestriction)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllGoldenEditionBooksWithLessThanCopies(EditionType editionType, Integer copies) {
        return bookRepository.findAllByEditionTypeAndCopiesLessThan(editionType, 5000)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksWithPriceLowerThanAndHigherThan(BigDecimal lower, BigDecimal upper) {
        return bookRepository.findAllByPriceLessThanOrPriceGreaterThan(lower, upper)
                .stream()
                .map(book -> String.format("%s - $%s", book.getTitle(), book.getPrice().setScale(2, RoundingMode.HALF_UP)))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesNotReleasedInYear(int year) {
        LocalDate before = LocalDate.of(year, 1, 1);
        LocalDate after = LocalDate.of(year, 12, 31);

        return bookRepository.findAllByReleaseDateBeforeOrReleaseDateAfter(before, after)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksReleasedAfterDate(LocalDate date) {
        return bookRepository.findAllByReleaseDateBefore(date)
                .stream()
                .map(book -> String.format("%s %s %s",
                        book.getTitle(),
                        book.getEditionType(),
                        book.getPrice().setScale(2, RoundingMode.HALF_UP)))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBookTitlesContaining(String str) {
        return bookRepository.findAllByTitleContaining(str)
                .stream()
                .map(Book::getTitle)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllBooksAuthorsLastNameStartsWith(String str) {
        return bookRepository.findAllByAuthorLastNameStartsWith(str)
                .stream()
                .map(book -> String.format("%s (%s %s)",
                        book.getTitle(),
                        book.getAuthor().getFirstName(),
                        book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public int getCountOfBooksWithTitleLongerThan(int length) {
        return bookRepository.countAllByTitleIsLongerThan(length);
    }

    @Override
    public String getBookInfoByTitle(String title) {
        Book book = bookRepository.findAllByTitleEquals(title).get(0);
        return String.format("%s %s %s %s",
                        book.getTitle(),
                        book.getEditionType(),
                        book.getAgeRestriction(),
                        book.getPrice());
    }

    private Book createBook(String[] bookData) {
        EditionType editionType = EditionType.values()[Integer.parseInt(bookData[0])];
        LocalDate releaseDate = LocalDate.parse(bookData[1], DateTimeFormatter.ofPattern("d/M/yyyy"));
        int copies = Integer.parseInt(bookData[2]);
        BigDecimal price = new BigDecimal(bookData[3]);
        AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(bookData[4])];
        String title = Arrays.stream(bookData).skip(5).collect(Collectors.joining(" "));
        Author author = authorService.getRandomAuthor();
        Set<Category> categories = categoryService.getRandomCategories();

        return new Book(editionType, releaseDate, copies, price, ageRestriction, title, author, categories);
    }
}
