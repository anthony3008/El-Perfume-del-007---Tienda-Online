package com.perfumeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.perfumeshop.service.CartService;
import com.perfumeshop.service.PerfumeService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HomeController {

    @Autowired
    private PerfumeService perfumeService;

    @Autowired
    private CartService cartService;

    @GetMapping("/")
    public String home(Model model, HttpSession session) {
        model.addAttribute("productos", perfumeService.obtenerTodos());
        
        Object carrito = session.getAttribute("carrito");
        int cartCount = 0;
        if (carrito != null) {
            cartCount = cartService.contarItems((java.util.List) carrito);
        }
        model.addAttribute("cartCount", cartCount);
        
        return "index";
    }
}
