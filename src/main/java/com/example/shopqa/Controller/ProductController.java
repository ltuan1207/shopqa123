package com.example.shopqa.Controller;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.service.ProductCategoryService;
import com.example.shopqa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/category/{categoryId}/products")
    public String showProductsByCategory(@PathVariable int categoryId, Model model) {
        List<ProductCategory> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        ProductCategory category = categoryService.getCategoryById(categoryId);
        List<Product> products = productService.getProductsByCategory(category);
        model.addAttribute("products", products);
        /*model.addAttribute("selectedCategoryId", categoryId);*/
        model.addAttribute("ProductCategory", category);
        return "home/products";
    }
}