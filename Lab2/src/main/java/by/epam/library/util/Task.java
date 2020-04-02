package by.epam.library.util;

import by.epam.library.entity.Author;
import by.epam.library.entity.Book;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Task {
    private final static Logger logger = LogManager.getLogger();

    public static boolean isPagesMore200(Book[] books) {
        return Arrays.stream(books)
                .peek(e -> logger.info("Peek: " + e))
                .anyMatch(book -> book.getNumberOfPages() > 200);
    }

    public static Book[] bounds(Book[] books) {
        List<Book> list = Arrays.stream(books)
                .sorted(Comparator.comparingInt(Book::getNumberOfPages))
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .collect(Collectors.toList());
        return new Book[]{list.get(0), list.get(list.size() - 1)};
    }

    public static Book[] singleAuthor(Book[] books) {
        return Arrays.stream(books)
                .distinct()
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .collect(Collectors.toList()).toArray(Book[]::new);
    }

    public static Book[] sortByPagesAndAuthors(Book[] books) {
        return Arrays.stream(books)
                .sorted(Comparator.comparingInt(Book::getNumberOfPages).thenComparing(Book::getTitle))
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .collect(Collectors.toList()).toArray(Book[]::new);
    }

    public static List<Author>[] getAuthors(Book[] books) {
        return Arrays.stream(books)
                .map(Book::getAuthors)
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .collect(Collectors.toList()).toArray(List[]::new);
    }


    public static void printAuthors(Book[] books) {
        Arrays.stream(books)
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .forEach(book -> System.out.println(book.getAuthors()));
    }

    public static List<Author>[] getDistinctAuthors(Book[] books) {
        return Arrays.stream(books)
                .map(Book::getAuthors)
                .distinct()
                .peek(e -> {
                    logger.info("Peek: " + e);
                })
                .collect(Collectors.toList()).toArray(List[]::new);
    }
}
