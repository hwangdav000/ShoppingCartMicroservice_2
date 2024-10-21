package com.synergisticit.controller;

import com.synergisticit.domain.Cart;
import com.synergisticit.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carts")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/save")
    public Cart saveCart(@RequestParam Integer productId, @RequestParam Integer userId) {
        return cartService.saveCart(productId, userId);
    }

    @GetMapping("/user/{userId}")
    public List<Cart> getCartsByUser(@PathVariable Integer userId) {
        return cartService.getCartsByUser(userId);
    }
    
    @GetMapping("/count/{userId}")
    public Integer getCountCart(@PathVariable Integer userId) {
        return cartService.getCountCart(userId);
    }

    @PutMapping("/updateQuantity")
    public void updateQuantity(@RequestParam String sy, @RequestParam Integer cid) {
        cartService.updateQuantity(sy, cid);
    }
}
