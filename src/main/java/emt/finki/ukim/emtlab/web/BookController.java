package emt.finki.ukim.emtlab.web;

import emt.finki.ukim.emtlab.model.Author;
import emt.finki.ukim.emtlab.model.Book;
import emt.finki.ukim.emtlab.model.Category;
import emt.finki.ukim.emtlab.model.dataTransfer.BookDto;
import emt.finki.ukim.emtlab.service.AuthorService;
import emt.finki.ukim.emtlab.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping({"/", "/books"})
    public List<Book> showAllBooks(){
        return this.bookService.listALlBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(book -> ResponseEntity.ok().body(book))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/books/add")
    public void addBook(@RequestBody BookDto bookDto){

         this.bookService.addBook(bookDto);
    }

    @PutMapping("/books/edit/{id}")
    public Book editBook(@PathVariable Long id, @RequestBody BookDto bookDto){
        return this.bookService.editBook(id, bookDto);
    }

    @DeleteMapping("/books/delete/{id}")
    public void deleteBook(@PathVariable Long id){
        this.bookService.deleteBook(id);
    }
}
