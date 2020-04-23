package by.epam.library.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author implements Serializable {
    private short age;
    private List<Book> books;

    public Author() {
        age = 0;
        this.books = new ArrayList<>();
    }

    public Author(short age, List<Book> books) {
        this.age = age;
        this.books = books;
    }

    public short getAge() {
        return age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void removeBook(Book book) {
        this.books.remove(book);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Author{");
        sb.append("age=").append(age);
        sb.append(", books=").append(books);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return age == author.age &&
                Objects.equals(books, author.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, books);
    }
}
