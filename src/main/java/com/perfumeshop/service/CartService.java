package com.perfumeshop.service;

import com.perfumeshop.model.CartItem;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CartService {
    
    public double calcularTotal(List<CartItem> carrito) {
        if (carrito == null) return 0.0;
        return carrito.stream().mapToDouble(CartItem::getTotal).sum();
    }
    
    public int contarItems(List<CartItem> carrito) {
        if (carrito == null) return 0;
        return carrito.stream().mapToInt(CartItem::getQuantity).sum();
    }
}