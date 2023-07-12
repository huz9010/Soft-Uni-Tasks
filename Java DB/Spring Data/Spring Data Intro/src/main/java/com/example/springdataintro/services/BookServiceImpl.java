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
    public List<Book> findBooksByReleaseDateAfter(int year) {
        return bookRepository.findBooksByReleaseDateAfter(LocalDate.of(year, 12, 31));
    }

    @Override
    public List<String> findAllAuthorsWithBookReleaseDateBefore(int year) {
        return bookRepository.findBookByReleaseDateBefore(LocalDate.of(year, 1, 1))
                .stream().map(book -> String.format("%s %s", book.getAuthor().getFirstName(), book.getAuthor().getLastName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllBooksByAuthorFullNameOrderByReleaseDateDescTitle(String firstName, String lastName) {
        return bookRepository.findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(firstName, lastName)
                .stream().map(book -> String.format("%s %s %d",
                        book.getTitle(),
                        book.getReleaseDate(),
                        book.getCopies()))
                .collect(Collectors.toList());
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
