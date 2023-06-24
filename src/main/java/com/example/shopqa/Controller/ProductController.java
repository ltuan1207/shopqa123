package com.example.shopqa.Controller;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.service.ProductCategoryService;
import com.example.shopqa.service.ProductService;
import com.example.shopqa.service.ProductServiceInter;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductServiceInter productServiceInter;

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

    @GetMapping("/createProduct")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/create_product";
    }

    @PostMapping("/createProduct")
    public String create(@Valid Product newProduct, @RequestParam MultipartFile imageProduct, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("product",newProduct);
            return "admin/create_product";
        }
        if(imageProduct != null && imageProduct.getSize() > 0)
        {
            try {
                File saveFile = new ClassPathResource("static/img").getFile();
                String newImageFile = UUID.randomUUID() + ".png";
                Path path = Paths.get(saveFile.getAbsolutePath() +File.separator + newImageFile);
                Files.copy(imageProduct.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
                newProduct.setImageUrl(newImageFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            productService.saveProduct(newProduct);
            return "redirect:/products";
    }

    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product, Model model){
        productServiceInter.saveProduct(product);
        return "redirect:/";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable(value = "id") int id, Model model) {
        Product product = productServiceInter.getProductById(id);
        model.addAttribute("product", product);
        return "admin/edit";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        productServiceInter.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("/allProduct")
    public String showAllProduct(Model model) {
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("category", categoryService.getAllCategories());
        return "admin/list_product";
    }

}