package com.example.e_commercecustomers_ead.services;

import com.example.e_commercecustomers_ead.models.Product;

import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;
    private List<Product> cartItems;

    private CartManager() {
        cartItems = new ArrayList<>();
    }

    public static CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }

    public void addToCart(Product product) {
        cartItems.add(product);
        product.setInCart(true);
    }

    public boolean isInCart(Product product) {
        return cartItems.contains(product);
    }

    public List<Product> getCartItems() {
        return cartItems;
    }
}

