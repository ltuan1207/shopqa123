package com.example.shopqa.Controller;

import com.example.shopqa.entity.CartItem;
import com.example.shopqa.entity.Product;
import com.example.shopqa.service.CartService;
import com.example.shopqa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

    @GetMapping("")
    public String getCartItems(Model model) {
        List<CartItem> cartItems = cartService.getCartItems();
        model.addAttribute("cartItems", cartItems);
// Calculate the total price
        long totalPrice = cartItems.stream()
                .mapToLong(cartItem -> cartItem.getPrice() *
                        cartItem.getQuantity())
                .sum();
        model.addAttribute("totalPrice", totalPrice);
// Calculate cart count
        model.addAttribute("cartCount", cartItems.size());
        return "cart/index";
    }

    @PostMapping("add/{id}")
    public String addToCart(@PathVariable("id") Integer productId) {
        Product product = productService.get(productId);
        if (product != null) {
            cartService.addToCart(product);
        }
        return "redirect:/cart";
    }
    @PostMapping("/update")
    public String updateCartItem(@RequestParam("productId") Integer productId, @RequestParam("quantity") int quantity) {
        cartService.updateCartItem(productId, quantity);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable("productId") Integer productId) {
        cartService.removeFromCart(productId);
        return "redirect:/cart";
    }
}
