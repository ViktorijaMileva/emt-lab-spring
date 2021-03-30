package emt.finki.ukim.emtlab.service;

import emt.finki.ukim.emtlab.model.Author;

import java.util.Optional;

public interface AuthorService {

    public Optional<Author> findById(Long id);
}
