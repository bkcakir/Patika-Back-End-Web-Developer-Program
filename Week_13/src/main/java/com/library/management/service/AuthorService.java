package com.library.management.service;

import com.library.management.entity.Author;
import com.library.management.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthorService {
    
    private final AuthorRepository authorRepository;
    
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }
    
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }
    
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }
    
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
    
    public Author updateAuthor(Long id, Author authorDetails) {
        Optional<Author> author = authorRepository.findById(id);
        if (author.isPresent()) {
            Author existingAuthor = author.get();
            existingAuthor.setName(authorDetails.getName());
            existingAuthor.setBirthDate(authorDetails.getBirthDate());
            existingAuthor.setCountry(authorDetails.getCountry());
            return authorRepository.save(existingAuthor);
        }
        return null;
    }
} 