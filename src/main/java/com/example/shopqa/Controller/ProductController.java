package com.example.shopqa.Controller;

import com.example.shopqa.entity.Product;
import com.example.shopqa.entity.ProductCategory;
import com.example.shopqa.service.ProductCategoryService;
import com.example.shopqa.service.ProductService;
import com.example.shopqa.service.ProductServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private ProductCategoryService categoryService;

    @Autowired
    private ProductServiceInter productServiceInter;

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
    @GetMapping("/allProduct")
    public String showAllProduct(Model model) {
        List<Product> products = productServiceInter.getAllProduct();
        model.addAttribute("products", products);
        model.addAttribute("category", categoryService.getAllCategories());
        return "admin/list_product";
    }

    @GetMapping("/createProduct")
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "admin/create_product";
    }
    @PostMapping("/createProduct")
    public String createProduct(@RequestBody @ModelAttribute Product product){
        productService.saveProduct(product);
        return "redirect:/product/allProduct";
    }

    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.get(id));
        model.addAttribute("categories",categoryService.getAllCategories());
        return "admin/edit_product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product editProduct) {
        productService.edit(editProduct);
        return "redirect:/product/allProduct";
    }
    //
    //Delete Book
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        productService.deleteProduct(id);
        return "redirect:/product/allProduct";
    }
}