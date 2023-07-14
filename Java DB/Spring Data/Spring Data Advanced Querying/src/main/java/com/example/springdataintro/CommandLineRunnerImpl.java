package com.example.springdataintro;

import com.example.springdataintro.enums.AgeRestriction;
import com.example.springdataintro.enums.EditionType;
import com.example.springdataintro.services.interfaces.AuthorService;
import com.example.springdataintro.services.interfaces.BookService;
import com.example.springdataintro.services.interfaces.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component()
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader reader;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader reader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.reader = reader;
    }

    @Override
    public void run(String... args) throws Exception {

        seedDatabase();

        printMenu();
        String input = this.reader.readLine();

        while (!input.equals("0")) {

            switch (input) {
                case "1" -> printAllBooksByAgeRestriction();

                case "2" -> printAllGoldenEditionBooksWithLessThan5000Copies();

                case "3" -> printTitlesAndPricesOfBooksWithPriceLowerThan5AndHigherThan40();

                case "4" -> printTitlesOfBooksNotReleasedInYear();

                case "5" -> printTitlesEditionAndPriceOfBooksReleasedBeforeDate();

                case "6" -> printAuthorsWhichFirstNameEndsWith();

                case "7" -> printTitlesOfBooksWhichContain();

                case "8" -> printTitlesAndAuthorsOfBooksWhichAuthorsLastNameStarsWith();

                case "9" -> printNumberOfBooksWhichTitleIsLongerThan();

                case "10" -> printAuthorsWithTotalCountOfCopies();

                case "11" -> printBookInfoByTitle();

                default -> {
                    System.out.println("Invalid operation! Please choose a valid option: ");
                    input = reader.readLine();
                    continue;
                }
            }
            printMenu();
            input = reader.readLine();
        }
    }

    private void printBookInfoByTitle() throws IOException {
        System.out.print("Enter a book title to search: ");
        String title = reader.readLine().trim();
        System.out.println(bookService.getBookInfoByTitle(title));
    }

    private void printAuthorsWithTotalCountOfCopies() {
        authorService.getAuthorsWithTotalCopies()
                .forEach(a -> System.out.println(a[0] + " - " + a[1]));
    }

    private void printNumberOfBooksWhichTitleIsLongerThan() throws IOException {
        System.out.print("Enter number to compare title length:  ");
        int length = Integer.parseInt(reader.readLine());
        System.out.println(bookService.getCountOfBooksWithTitleLongerThan(length));
    }

    private void printTitlesAndAuthorsOfBooksWhichAuthorsLastNameStarsWith() throws IOException {
        System.out.print("Enter a string to search for author with lastname starting with it: ");
        String str = reader.readLine();
        bookService.getAllBooksAuthorsLastNameStartsWith(str)
                .forEach(System.out::println);
    }

    private void printTitlesOfBooksWhichContain() throws IOException {
        System.out.print("Enter a string to search for book title containing it: ");
        String str = reader.readLine();
        bookService.getAllBookTitlesContaining(str)
                .forEach(System.out::println);
    }

    private void printAuthorsWhichFirstNameEndsWith() throws IOException {
        System.out.print("Enter string for author firstname ending: ");
        String str = reader.readLine();
        authorService.getAllAuthorsNamesFirstNameEndingWith(str)
                .forEach(System.out::println);
    }

    private void printTitlesEditionAndPriceOfBooksReleasedBeforeDate() throws IOException {
        System.out.print("Enter date in format dd-MM-yyyy: ");
        LocalDate date = LocalDate.parse(reader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService.getAllBooksReleasedAfterDate(date)
                .forEach(System.out::println);
    }

    private void printTitlesOfBooksNotReleasedInYear() throws IOException {
        System.out.print("Enter year: ");
        int year = Integer.parseInt(reader.readLine());
        bookService.getAllBookTitlesNotReleasedInYear(year)
                .forEach(System.out::println);
    }

    private void printTitlesAndPricesOfBooksWithPriceLowerThan5AndHigherThan40() {
        bookService.getAllBooksWithPriceLowerThanAndHigherThan(BigDecimal.valueOf(5), BigDecimal.valueOf(40))
                .forEach(System.out::println);
    }

    private void printAllGoldenEditionBooksWithLessThan5000Copies() {
        bookService.getAllGoldenEditionBooksWithLessThanCopies(EditionType.GOLD, 5000)
                .forEach(System.out::println);
    }

    private void printAllBooksByAgeRestriction() throws IOException {
        System.out.print("Enter age restriction: ");
        AgeRestriction ageRestriction = AgeRestriction.valueOf(reader.readLine().toUpperCase());
        bookService.getAllBookTitlesByAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void seedDatabase() throws IOException {
        this.categoryService.seedCategories();
        this.authorService.seedAuthors();
        this.bookService.seedBooks();
    }

    private void printMenu() {
        System.out.println("Please choose a task to start or 0 to end the program:\n" +
                "1. Books Titles by Age Restriction\n" +
                "2. Golden Books\n" +
                "3. Books by Price\n" +
                "4. Not Released Books\n" +
                "5. Books Released Before Date\n" +
                "6. Authors Search\n" +
                "7. Books Search\n" +
                "8. Book Titles Search\n" +
                "9. Count Books\n" +
                "10. Total Book Copies\n" +
                "11. Reduced Book\n" +
                "0. Exit");
    }
}
