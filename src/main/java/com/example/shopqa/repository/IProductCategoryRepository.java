package com.example.shopqa.repository;

import com.example.shopqa.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface IProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
    }
