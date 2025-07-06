package com.library.management.service;

import com.library.management.entity.Category;
import com.library.management.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    
    private final CategoryRepository categoryRepository;
    
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
    
    public Optional<Category> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }
    
    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }
    
    public String deleteCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            // Kategoriye ait kitap var mı kontrol et
            if (category.get().getBooks() != null && !category.get().getBooks().isEmpty()) {
                return "Bu kategoriye ait kitap var. Bu kategori silinemedi.";
            }
            categoryRepository.deleteById(id);
            return "Kategori başarıyla silindi.";
        }
        return "Kategori bulunamadı.";
    }
    
    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Category existingCategory = category.get();
            existingCategory.setName(categoryDetails.getName());
            existingCategory.setDescription(categoryDetails.getDescription());
            return categoryRepository.save(existingCategory);
        }
        return null;
    }
} 