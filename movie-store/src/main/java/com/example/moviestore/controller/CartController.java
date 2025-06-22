package com.example.moviestore.controller;

import com.example.moviestore.dto.CartItem;
import com.example.moviestore.model.Movie;
import com.example.moviestore.service.MovieService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    private final MovieService service;

    public CartController(MovieService service) {
        this.service = service;
    }

    @GetMapping
    public String viewCart(HttpSession session, Model model) {
        Map<Long, CartItem> cart = getCart(session);
        model.addAttribute("items", cart.values());
        model.addAttribute("total", cart.values().stream().mapToDouble(CartItem::getTotalPrice).sum());
        return "cart";
    }

    @PostMapping("/add/{id}")
    public String addToCart(@PathVariable Long id, HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        cart.compute(id, (k, v) -> v == null ? new CartItem(service.getById(id), 1) : new CartItem(v.getMovie(), v.getQuantity() + 1));
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @PostMapping("/remove/{id}")
    public String removeFromCart(@PathVariable Long id, HttpSession session) {
        Map<Long, CartItem> cart = getCart(session);
        cart.remove(id);
        session.setAttribute("cart", cart);
        return "redirect:/cart";
    }

    @SuppressWarnings("unchecked")
    private Map<Long, CartItem> getCart(HttpSession session) {
        return (Map<Long, CartItem>) session.getAttribute("cart") != null ?
                (Map<Long, CartItem>) session.getAttribute("cart") : new HashMap<>();
    }
}