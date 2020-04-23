package by.epam.library.dao;

import by.epam.library.entity.Author;

public class AuthorDAO extends DAO<Author>{
    private final String path = "data/author.dat";

    @Override
    public String getPath() {
        return path;
    }
}