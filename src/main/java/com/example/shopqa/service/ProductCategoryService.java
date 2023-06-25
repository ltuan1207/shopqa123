package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.repository.IProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService implements ProductCategoryServiceInter {
    @Autowired
    private IProductCategoryRepository categoryRepository;

    private ProductCategory productCategory;
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


    @Override
    public List<ProductCategory> getProductsByCategory(ProductCategory category) {
        return null;
    }

    @Override
    public List<ProductCategory> getAllProductCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
        categoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory getProductCategoryById(int id) {
        Optional<ProductCategory> optional = categoryRepository.findById(id);
        ProductCategory productCategory = null;

        if (optional.isPresent()) {
            productCategory = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return productCategory;
    }

    @Override
    public void deleteProductCategoryById(int id) {
        categoryRepository.deleteById(id);
    }
    public void editProductCategory(ProductCategory productCategory){
        categoryRepository.save(productCategory);
    }

}
