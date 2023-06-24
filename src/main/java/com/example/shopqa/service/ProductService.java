package com.example.shopqa.service;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.repository.IProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductService implements ProductServiceInter {
    @Autowired
    private IProductsRepository productsRepository;
    private Product product;


    @Override
    public List<Product> getProductsByCategory(ProductCategory category) {
        return productsRepository.findByCategory(category);
    }

    @Override
    public List<Product> getAllProduct() {
        return productsRepository.findAll();
    }

    @Override
    public void saveProduct(Product product) {

        this.product=product;
        productsRepository.save(product);
    }

    @Override
    public Product getProductById(int id) {
        Optional<Product> optional = productsRepository.findById(id);
        Product product = null;

        if (optional.isPresent()) {
            product = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return product;
    }

    @Override
    public void deleteProductById(int id) {
        productsRepository.deleteById(id);
    }

    public Product get(int id) {
        return  productsRepository.findById(id).stream().findFirst().orElse(null);
    }

    public void addProduct(Product product){
        productsRepository.save(product);
    }

    public void editProduct(Product product){
        productsRepository.save(product);
    }


//    public Product deleteProductById(Integer id){
//        Product product = null;
//        productsRepository.deleteById(id);
//        return product;
//    }

}
