package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;


import java.util.List;

public interface ProductCategoryServiceInter {
    List<ProductCategory> getProductsByCategory(ProductCategory category);

    List<ProductCategory> getAllProductCategory();
    void saveProductCategory(ProductCategory productCategory);
    ProductCategory getProductCategoryById(int id);
    void deleteProductCategoryById(int id);


}
