package emt.finki.ukim.emtlab.service.impl;

import emt.finki.ukim.emtlab.model.Author;
import emt.finki.ukim.emtlab.repository.AuthorRepository;
import emt.finki.ukim.emtlab.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }
}
