package emt.finki.ukim.emtlab.service;

import emt.finki.ukim.emtlab.model.Author;

import java.util.Optional;
import java.util.List;

public interface AuthorService {

    public Optional<Author> findById(Long id);

    public List<Author> showAllAuthors();
}
