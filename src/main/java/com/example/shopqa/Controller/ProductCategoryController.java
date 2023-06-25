package com.example.shopqa.Controller;

import com.example.shopqa.service.ProductCategoryService;
import com.example.shopqa.service.ProductCategoryServiceInter;
import com.example.shopqa.service.ProductService;
import com.example.shopqa.service.ProductServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.shopqa.entity.ProductCategory;
import org.springframework.ui.Model;

import java.util.List;


@Controller
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Autowired
    private ProductCategoryServiceInter productCategoryServiceInter;

    @Autowired
    private ProductCategoryService categoryService;

    @GetMapping("/allProductCategory")
    public String showAllProduct(Model model) {
        List<ProductCategory> categories = productCategoryService.getAllProductCategory();
        model.addAttribute("categories", categories);
        return "admin/list_category";
    }

    @GetMapping("/createProductCategory")
    public String createProductCategory(Model model){
        model.addAttribute("category", new ProductCategory());
        return "admin/create_category";
    }
    @PostMapping("/createProductCategory")
    public String createProductCategory(@RequestBody @ModelAttribute ProductCategory productCategory){
        productCategoryService.saveProductCategory(productCategory);
        return "redirect:/category/allProductCategory";
    }

    @GetMapping("/editProductCategory/{id}")
    public String editProductCategory(@PathVariable(value = "id") int id, Model model) {
        ProductCategory productCategory = productCategoryService.getProductCategoryById(id);
        model.addAttribute("category", new ProductCategory());
        model.addAttribute("category", productCategory);
        return "admin/edit_category";
    }

    @PostMapping("/edit-save")
    public String editProductCategory(@ModelAttribute("product") ProductCategory editProductCategory) {
        productCategoryService.saveProductCategory(editProductCategory);
        return "redirect:/category/allProductCategory";
    }
    //
    //Delete Book
    @GetMapping("/deleteProductCategory")
    public String deleteProductCategory(@RequestParam("id") int id) {
        productCategoryService.deleteProductCategoryById(id);
        return "redirect:/category/allProductCategory";
    }

}
