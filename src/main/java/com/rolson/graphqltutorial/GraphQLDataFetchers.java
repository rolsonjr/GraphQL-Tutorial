package com.rolson.graphqltutorial;

import com.rolson.graphqltutorial.models.Author;
import com.rolson.graphqltutorial.models.Book;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class GraphQLDataFetchers {
    private static final List<Book> books = Arrays.asList(
            Book.builder()
                    .id("book-1")
                    .name("Harry Potter and the Philosopher's Stone")
                    .pageCount(223)
                    .authorId("author-1")
                    .build(),
            Book.builder()
                    .id("book-2")
                    .name("Moby Dick")
                    .pageCount(635)
                    .authorId("author-2")
                    .build(),
            Book.builder()
                    .id("book-3")
                    .name("Interview with the vampire")
                    .pageCount(371)
                    .authorId("author-3")
                    .build());

    private static final List<Author> authors = Arrays.asList(
            Author.builder()
                    .id("author-1")
                    .firstName("Joanne")
                    .lastName("Rowling")
                    .build(),
            Author.builder()
                    .id("author-2")
                    .firstName("Herman")
                    .lastName("Melville")
                    .build(),
            Author.builder()
                    .id("author-3")
                    .firstName("Anne")
                    .lastName("Rice")
                    .build());

    public DataFetcher<Book> getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher<Author> getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            final Book book = dataFetchingEnvironment.getSource();
            String authorId = book.getAuthorId();
            return authors
                    .stream()
                    .filter(author -> author.getId().equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
