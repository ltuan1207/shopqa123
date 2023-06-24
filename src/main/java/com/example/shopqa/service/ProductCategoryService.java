package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {
    @Autowired
    private IProductCategoryRepository categoryRepository;
    public List<ProductCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

/*    public ProductCategory getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);

    }*/
    public ProductCategory getCategoryById(int id) {
        Optional<ProductCategory> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isPresent()) {
            return optionalCategory.get();
        } else {
            throw new RuntimeException(" Category not found");
        }
    }

    public ProductCategory saveCategory(ProductCategory category){ return categoryRepository.save(category);}

    public void deleteCategory(Integer id) {categoryRepository.deleteById(id);}

}
