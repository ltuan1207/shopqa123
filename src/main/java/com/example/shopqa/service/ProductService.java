package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private IProductsRepository productsRepository;

    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    public List<Product> getProductsByCategory(ProductCategory category) {
        return productsRepository.findByCategory(category);
    }
    public Product get(int id) {
        return  productsRepository.findById(id).stream().findFirst().orElse(null);
    }

}
