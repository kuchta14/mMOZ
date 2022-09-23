package com.example.mMOZ.controller;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.service.OrderApiService;
import com.example.mMOZ.service.ProductsService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/")
@Controller
public class Order {

    private final OrderApiService orderApiService;
    private final ProductsService productsService;

    public Order(OrderApiService orderApiService, ProductsService productsService) {
        this.orderApiService = orderApiService;
        this.productsService = productsService;
    }

    @GetMapping()
    public String readTopOrder(Model model) {
        model.addAttribute("orders", orderApiService.findTop10ByOrderNumberDesc());
        return "orders";
    }

    @GetMapping("all")
    public String readAllOrders(Model model, @PageableDefault(size = 2, sort = "order_number") Pageable page) {
        model.addAttribute("orders", orderApiService.findAll());
        return "orders";
    }

    //    @GetMapping("order/{order_number}")
//    ResponseEntity <Orders> readByOrder(@PathVariable long order_number) {
//        return ResponseEntity.ok(orderApiService.findByOrderNumber(order_number));
//    }
    @GetMapping("order/{order_number}")
    public String readByOrder(@PathVariable long order_number, Model model) {
        model.addAttribute("order", orderApiService.findByOrderNumber(order_number));
        model.addAttribute("products", productsService.findByOrderNumberProducts(order_number));
        return "ordersSpecific";
    }


    @PostMapping("setOrder")
    public String setOrder(Orders order,@RequestParam  List<String> products) {
        orderApiService.save(order,products);
        return "redirect:/";
    }

    @PostMapping("order/cancel/{order_number}")
    public String cancelOrder(@PathVariable long order_number, Model model){
        Orders order = orderApiService.findByOrderNumber(order_number);
        order.setStatus(-1);

        orderApiService.update(order);
        model.addAttribute("order", order);
        return "ordersSpecific";
    }


}