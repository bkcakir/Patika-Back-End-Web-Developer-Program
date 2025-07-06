package com.library.management.controller;

import com.library.management.dto.BookBorrowingUpdateDto;
import com.library.management.entity.BookBorrowing;
import com.library.management.service.BookBorrowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book-borrowings")
@RequiredArgsConstructor
public class BookBorrowingController {
    
    private final BookBorrowingService bookBorrowingService;
    
    @GetMapping
    public ResponseEntity<List<BookBorrowing>> getAllBookBorrowings() {
        List<BookBorrowing> borrowings = bookBorrowingService.getAllBookBorrowings();
        return ResponseEntity.ok(borrowings);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<BookBorrowing> getBookBorrowingById(@PathVariable Long id) {
        Optional<BookBorrowing> borrowing = bookBorrowingService.getBookBorrowingById(id);
        return borrowing.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public ResponseEntity<BookBorrowing> createBookBorrowing(@RequestBody BookBorrowing bookBorrowing) {
        try {
            BookBorrowing savedBorrowing = bookBorrowingService.saveBookBorrowing(bookBorrowing);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedBorrowing);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<BookBorrowing> updateBookBorrowing(@PathVariable Long id, @RequestBody BookBorrowingUpdateDto updateDto) {
        BookBorrowing borrowingDetails = new BookBorrowing();
        borrowingDetails.setBorrowerName(updateDto.getBorrowerName());
        
        BookBorrowing updatedBorrowing = bookBorrowingService.updateBookBorrowing(id, borrowingDetails);
        if (updatedBorrowing != null) {
            return ResponseEntity.ok(updatedBorrowing);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PutMapping("/{id}/return")
    public ResponseEntity<BookBorrowing> returnBook(@PathVariable Long id) {
        BookBorrowing returnedBorrowing = bookBorrowingService.returnBook(id);
        if (returnedBorrowing != null) {
            return ResponseEntity.ok(returnedBorrowing);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookBorrowing(@PathVariable Long id) {
        bookBorrowingService.deleteBookBorrowing(id);
        return ResponseEntity.noContent().build();
    }
} 