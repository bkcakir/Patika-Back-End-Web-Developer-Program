package com.library.management.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingUpdateDto {
    
    @NotBlank(message = "Ödünç alan kişi adı boş olamaz")
    private String borrowerName;
} 