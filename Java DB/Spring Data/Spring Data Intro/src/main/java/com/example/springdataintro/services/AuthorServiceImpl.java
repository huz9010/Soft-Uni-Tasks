package com.example.springdataintro.services;

import com.example.springdataintro.enitities.Author;
import com.example.springdataintro.repositories.AuthorRepository;
import com.example.springdataintro.services.interfaces.AuthorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final String AUTHORS_FILE_PATH = "src/main/resources/authors.txt";

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {
        if (authorRepository.count() > 0) {
            return;
        }

        Files.readAllLines(Path.of(AUTHORS_FILE_PATH))
                .forEach(row -> {
                    String[] authorData = row.split("\\s+");
                    Author author = new Author(authorData[0], authorData[1]);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        long id = ThreadLocalRandom.current().nextLong(1, authorRepository.count() + 1);
        return authorRepository.findById(id).orElse(null);
    }

    @Override
    public List<String> getAllAuthorsByNumberOfBooksDesc() {
        return authorRepository.findAllByBooksSizeDesc()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(),
                        author.getLastName(),
                        author.getBooks().size()))
                .collect(Collectors.toList());
    }
}
