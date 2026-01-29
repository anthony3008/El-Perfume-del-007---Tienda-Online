package com.perfumeshop.controller;

import com.perfumeshop.model.CartItem;
import com.perfumeshop.model.Perfume;
import com.perfumeshop.service.CartService;
import com.perfumeshop.service.PerfumeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {

    @Autowired private PerfumeService perfumeService;
    @Autowired private CartService cartService;

    @PostMapping("/carrito/agregar")
    public String agregar(@RequestParam String id, @RequestParam(defaultValue = "1") int cantidad, HttpSession session) {
        if (id == null || id.trim().isEmpty() || cantidad <= 0) {
            return "redirect:/";
        }
        
        Perfume p = perfumeService.obtenerPorId(id);
        if (p == null) return "redirect:/producto/" + id;
        
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        if (carrito == null) carrito = new ArrayList<>();
        
        boolean existe = false;
        for (CartItem item : carrito) {
            if (item.getPerfume().getId().equals(id)) {
                item.setQuantity(item.getQuantity() + cantidad);
                existe = true;
                break;
            }
        }
        if (!existe) {
            carrito.add(new CartItem(p, cantidad));
        }

        session.setAttribute("carrito", carrito);
        return "redirect:/carrito";
    }

    @GetMapping("/carrito")
    public String verCarrito(Model model, HttpSession session) {
        List<CartItem> carrito = (List<CartItem>) session.getAttribute("carrito");
        if (carrito == null) carrito = new ArrayList<>();
        model.addAttribute("carrito", carrito);
        model.addAttribute("total", cartService.calcularTotal(carrito));
        return "carrito";
    }

    @PostMapping("/checkout")
    public String checkout(HttpSession session) {
        session.removeAttribute("carrito"); // Vaciar carrito
        return "checkout"; // Mostrar página de confirmación
    }
}