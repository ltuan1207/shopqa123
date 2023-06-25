package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductServiceInter {

    List<Product> getProductsByCategory(ProductCategory category);
    List<Product> getAllProduct();
    void saveProduct(Product product);
    Product getProductById(int id);
    void deleteProductById(int id);
}
