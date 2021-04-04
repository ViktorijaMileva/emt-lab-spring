package emt.finki.ukim.emtlab.web;

import emt.finki.ukim.emtlab.model.Author;
import emt.finki.ukim.emtlab.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/books/authors")
    public List<Author> authors(){
        return this.authorService.showAllAuthors();
    }
}
