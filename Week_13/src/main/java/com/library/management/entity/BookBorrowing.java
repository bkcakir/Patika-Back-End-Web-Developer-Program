package com.library.management.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "book_borrowings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "borrower_name", nullable = false)
    private String borrowerName;
    
    @Column(name = "borrower_email", nullable = false)
    private String borrowerEmail;
    
    @Column(name = "borrowing_date", nullable = false)
    private LocalDate borrowingDate;
    
    @Column(name = "return_date")
    private LocalDate returnDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
} 