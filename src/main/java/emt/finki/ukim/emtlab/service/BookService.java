package emt.finki.ukim.emtlab.service;

import emt.finki.ukim.emtlab.model.Book;
import emt.finki.ukim.emtlab.model.Category;
import emt.finki.ukim.emtlab.model.dataTransfer.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public List<Book> listALlBooks();

    public Optional<Book> findById(Long id);

    public Book addBook(String name, Category category, Long authorId, int availableCopies);

    public Book addBook(BookDto bookDto);

    public Book editBook(Long id, String name, Category category, Long authorId, int availableCopies);

    public Book editBook(Long id, BookDto bookDto);

    public void deleteBook(Long id);
}
