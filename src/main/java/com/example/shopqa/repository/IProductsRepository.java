package com.example.shopqa.repository;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductsRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(ProductCategory category);
    @Query("SELECT p FROM Product p WHERE p.name like  %:key%")
    Page<Product> searchProducts(@Param("key") String key, Pageable pageable);
}
