package com.library.management.service;

import com.library.management.entity.Book;
import com.library.management.entity.BookBorrowing;
import com.library.management.repository.BookBorrowingRepository;
import com.library.management.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookBorrowingService {
    
    private final BookBorrowingRepository bookBorrowingRepository;
    private final BookRepository bookRepository;
    
    public List<BookBorrowing> getAllBookBorrowings() {
        return bookBorrowingRepository.findAll();
    }
    
    public Optional<BookBorrowing> getBookBorrowingById(Long id) {
        return bookBorrowingRepository.findById(id);
    }
    
    public BookBorrowing saveBookBorrowing(BookBorrowing bookBorrowing) {
        // Stok kontrolü
        Optional<Book> book = bookRepository.findById(bookBorrowing.getBook().getId());
        if (book.isPresent()) {
            Book existingBook = book.get();
            if (existingBook.getStock() > 0) {
                // Stoku azalt
                existingBook.setStock(existingBook.getStock() - 1);
                bookRepository.save(existingBook);
                
                // Ödünç alma tarihini set et
                bookBorrowing.setBorrowingDate(LocalDate.now());
                return bookBorrowingRepository.save(bookBorrowing);
            } else {
                throw new RuntimeException("Kitap stokta bulunmamaktadır.");
            }
        }
        throw new RuntimeException("Kitap bulunamadı.");
    }
    
    public BookBorrowing returnBook(Long id) {
        Optional<BookBorrowing> bookBorrowing = bookBorrowingRepository.findById(id);
        if (bookBorrowing.isPresent()) {
            BookBorrowing existingBorrowing = bookBorrowing.get();
            existingBorrowing.setReturnDate(LocalDate.now());
            
            // Kitabın stokunu artır
            Book book = existingBorrowing.getBook();
            book.setStock(book.getStock() + 1);
            bookRepository.save(book);
            
            return bookBorrowingRepository.save(existingBorrowing);
        }
        return null;
    }
    
    public void deleteBookBorrowing(Long id) {
        bookBorrowingRepository.deleteById(id);
    }
    
    public BookBorrowing updateBookBorrowing(Long id, BookBorrowing bookBorrowingDetails) {
        Optional<BookBorrowing> bookBorrowing = bookBorrowingRepository.findById(id);
        if (bookBorrowing.isPresent()) {
            BookBorrowing existingBorrowing = bookBorrowing.get();
            existingBorrowing.setBorrowerName(bookBorrowingDetails.getBorrowerName());
            return bookBorrowingRepository.save(existingBorrowing);
        }
        return null;
    }
} 