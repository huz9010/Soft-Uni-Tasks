package com.example.springdataintro;

import com.example.springdataintro.enitities.Book;
import com.example.springdataintro.services.interfaces.AuthorService;
import com.example.springdataintro.services.interfaces.BookService;
import com.example.springdataintro.services.interfaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Component()
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {

        seedDatabase();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        printMenu();
        String input = reader.readLine();

        while (!input.equals("0")) {

            switch (input) {
                case "1":
                    printAllBooksAfterYear(2000);
                    break;
                case "2":
                    printAllAuthorsWithBookBeforeYear(1990);
                    break;
                case "3":
                    printAllAuthorsWithBooksCountDesc();
                    break;
                case "4":
                    printAllBooksOfAuthorOrderByReleaseDateDescTitle("George", "Powell");
                    break;
                default:
                    System.out.println("Invalid operation! Please choose a valid option: ");
                    input = reader.readLine();
            }
            printMenu();
            input = reader.readLine();
        }
    }


    private void printAllBooksOfAuthorOrderByReleaseDateDescTitle(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFullNameOrderByReleaseDateDescTitle(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithBooksCountDesc() {
        authorService.getAllAuthorsByNumberOfBooksDesc()
                .forEach(System.out::println);
    }

    private void printAllAuthorsWithBookBeforeYear(int year) {
        bookService.findAllAuthorsWithBookReleaseDateBefore(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService.findBooksByReleaseDateAfter(year)
                .stream().map(Book::getTitle)
                .forEach(System.out::println);

    }

    private void seedDatabase() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }

    private void printMenu() {
        System.out.println("Please choose one of options below:\n" +
                "1. Get all books after the year 2000. Print only their titles.\n" +
                "2. Get all authors with at least one book with release date before 1990. Print their first name and last name.\n" +
                "3. Get all authors, ordered by the number of their books (descending). Print their first name, last name and book count.\n" +
                "4. Get all books from author George Powell, ordered by their release date (descending), then by book title (ascending). Print the book's title, release date and copies.");
    }
}
