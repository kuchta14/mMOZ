package com.example.mMOZ.controller;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.service.ProductsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("form")
public class OrderController {

    private final ProductsService productsService;

    public OrderController(ProductsService productsService) {
        this.productsService = productsService;
    }

    @GetMapping("/order")
    public String displayForm(Model model) {
        model.addAttribute("order", new Orders());
        return "formorders";
    }

    @ModelAttribute("products")
    public List<Products> products() {
        return productsService.findAll();
    }

}
