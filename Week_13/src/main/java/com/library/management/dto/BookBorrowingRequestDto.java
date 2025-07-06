package com.library.management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookBorrowingRequestDto {
    
    @NotBlank(message = "Ödünç alan kişi adı boş olamaz")
    private String borrowerName;
    
    @NotBlank(message = "Email adresi boş olamaz")
    @Email(message = "Geçerli bir email adresi giriniz")
    private String borrowerEmail;
    
    @NotNull(message = "Kitap bilgisi boş olamaz")
    private Long bookId;
} 