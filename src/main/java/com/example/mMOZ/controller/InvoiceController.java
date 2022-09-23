package com.example.mMOZ.controller;

import com.example.mMOZ.Entity.Invoice;
import com.example.mMOZ.Entity.Products;
import com.example.mMOZ.service.InvoiceService;
import com.example.mMOZ.service.OrderApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class InvoiceController {

    private final InvoiceService invoiceService;
    private final OrderApiService orderApiService;

    public InvoiceController(InvoiceService invoiceService, OrderApiService orderApiService) {
        this.invoiceService = invoiceService;
        this.orderApiService = orderApiService;
    }

    @GetMapping("/order/invoice/{order_number}")
    public String invoiceForm(Model model, @PathVariable long order_number) {
        model.addAttribute("invoice", new Invoice());
        model.addAttribute("order", orderApiService.findByOrderNumber(order_number).getOrder_number());
        return "formInvoice";
    }

    @PostMapping("/order/invoice")
    public String invoiceFormPost (Invoice invoice, Model model) {
        if (invoiceService.findInvoiceByorderNumber(invoice.getOrder_number()))
        {
            invoiceService.save(invoice);
        }
        else {
            model.addAttribute("false", "Faktura jest już wystawiona");
        }

        return "redirect:order/"+ invoice.getOrder_number();
    }



}
