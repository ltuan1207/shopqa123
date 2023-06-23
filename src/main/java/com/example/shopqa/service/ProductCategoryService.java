package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryService {
    @Autowired
    private IProductCategoryRepository categoryRepository;
    public List<ProductCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    public ProductCategory getCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
