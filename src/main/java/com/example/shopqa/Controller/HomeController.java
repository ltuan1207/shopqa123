package com.example.shopqa.Controller;


import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.service.ProductCategoryService;
import com.example.shopqa.service.ProductService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    private ProductService productService;

    @SneakyThrows
    @GetMapping
    public String home( Model model){
        List<ProductCategory> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "home/index";
    }
}
