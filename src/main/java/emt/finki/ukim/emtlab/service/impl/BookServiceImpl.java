package emt.finki.ukim.emtlab.service.impl;

import emt.finki.ukim.emtlab.model.Author;
import emt.finki.ukim.emtlab.model.Book;
import emt.finki.ukim.emtlab.model.Category;
import emt.finki.ukim.emtlab.model.dataTransfer.BookDto;
import emt.finki.ukim.emtlab.repository.AuthorRepository;
import emt.finki.ukim.emtlab.repository.BookRepository;
import emt.finki.ukim.emtlab.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listALlBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Book addBook(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow();
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        return this.bookRepository.save(book);
    }

    @Override
    public Book editBook(Long id, BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor()).orElseThrow();
        Book book = this.bookRepository.findById(id).orElseThrow();
        book.setName(bookDto.getName());
        book.setCategory(bookDto.getCategory());
        book.setAuthor(author);
        book.setAvailableCopies(bookDto.getAvailableCopies());  
        return this.bookRepository.save(book);
    }

    @Override
    public Book addBook(String name, Category category, Long authorId, int availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow();
        Book book = new Book(name, category, author, availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public Book editBook(Long id, String name, Category category, Long authorId, int availableCopies) {
        Author author = this.authorRepository.findById(authorId).orElseThrow();
        Book book = this.bookRepository.findById(id).orElseThrow();
        book.setName(name);
        book.setCategory(category);
        book.setAuthor(author);
        book.setAvailableCopies(availableCopies);
        return this.bookRepository.save(book);
    }

    @Override
    public void deleteBook(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow();
        this.bookRepository.delete(book);
    }
}
