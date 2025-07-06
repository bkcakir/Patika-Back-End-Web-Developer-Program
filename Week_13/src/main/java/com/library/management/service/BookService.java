package com.library.management.service;

import com.library.management.entity.Book;
import com.library.management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {
    
    private final BookRepository bookRepository;
    
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
    
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    public Book updateBook(Long id, Book bookDetails) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            Book existingBook = book.get();
            existingBook.setName(bookDetails.getName());
            existingBook.setPublicationYear(bookDetails.getPublicationYear());
            existingBook.setStock(bookDetails.getStock());
            existingBook.setAuthor(bookDetails.getAuthor());
            existingBook.setPublisher(bookDetails.getPublisher());
            existingBook.setCategories(bookDetails.getCategories());
            return bookRepository.save(existingBook);
        }
        return null;
    }
} 