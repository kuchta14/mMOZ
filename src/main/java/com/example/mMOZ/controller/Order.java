package com.example.mMOZ.controller;

import com.example.mMOZ.Entity.Orders;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.Rest.sendOrder;
import com.example.mMOZ.service.InvoiceService;
import com.example.mMOZ.service.OrderApiService;
import com.example.mMOZ.service.ProductsService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@RequestMapping("/")
@Controller
public class Order {

    private final OrderApiService orderApiService;
    private final ProductsService productsService;
    private final sendOrder sendOrder;

    private final InvoiceService invoiceService;

    public Order(OrderApiService orderApiService, ProductsService productsService, com.example.mMOZ.Rest.sendOrder sendOrder, InvoiceService invoiceService) {
        this.orderApiService = orderApiService;
        this.productsService = productsService;
        this.sendOrder = sendOrder;
        this.invoiceService = invoiceService;
    }

    @GetMapping()
    public String readTopOrder(Model model) {
        model.addAttribute("orders", orderApiService.findTop10ByOrderNumberDesc());
        //model.addAttribute("invoicenr",invoiceService.findInvoiceByorderNumberDoc(orderApiService.findTop10ByOrderNumberDesc().stream().toArray()..forEach(p->p.getOrder_number())));
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
        model.addAttribute("suma", productsService.findByOrderNumberProducts(order_number).stream().mapToDouble(p -> p.getPrice()).sum());
        return "ordersSpecific";
    }

    @PostMapping("setOrder")
    public String setOrder(@Valid @ModelAttribute("order") Orders order,BindingResult bindingResult,Model model, @NotBlank @RequestParam List<String> products) {
        if (bindingResult.hasErrors()) {
            return "formorders";
        }
        if (products.isEmpty()) {
            model.addAttribute("prod", "Wybierz produkt");
            return "formorders";
        }
        orderApiService.save(order,products);
        return "redirect:/";
    }

    @ModelAttribute("products")
    public List<Products> products() {
        return productsService.findAll();
    }


    @GetMapping("/form/order")
    public String displayForm(Model model) {
        model.addAttribute("order", new Orders());
        return "formorders";
    }

    @PostMapping("order/cancel/{order_number}")
    public String cancelOrder(@PathVariable long order_number, Model model){
        Orders order = orderApiService.findByOrderNumber(order_number);
        order.setStatus(-1);

        orderApiService.update(order);
        model.addAttribute("order", order);
        return "redirect:/order/"+order_number;
    }

    @GetMapping ("retryorder/{order_number}")
    public String retryOrder(@PathVariable long order_number, Model model){
        Orders order = orderApiService.findByOrderNumber(order_number);
      if (order.getStatus() == 0) {
          if (sendOrder.sendOrderErp(order.getOrder_number()) == HttpStatus.OK) {
              order.setStatus(1);
          } else {
              order.setStatus(0);
          }

          orderApiService.update(order);
      }
        model.addAttribute("order", order);
        return "redirect:/order/"+order_number;
    }



}