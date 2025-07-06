package com.library.management.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublisherRequestDto {
    
    @NotBlank(message = "Yayınevi adı boş olamaz")
    private String name;
    
    @NotNull(message = "Kuruluş yılı boş olamaz")
    @Min(value = 1800, message = "Kuruluş yılı 1800'den küçük olamaz")
    private Integer establishmentYear;
} 