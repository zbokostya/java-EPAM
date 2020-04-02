package by.epam.library.dao;

import by.epam.library.entity.Book;

public class BookDAO extends DAO<Book>{
    private final String path = "data/book.dat";

    @Override
    public String getPath() {
        return path;
    }
}
