package com.example.mMOZ.controller;

import com.example.mMOZ.Entity.Invoice;
import com.example.mMOZ.service.InvoiceService;
import com.example.mMOZ.service.OrderApiService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

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

    @GetMapping("/order/invoice/doc/{order_number}")
    public String invoiceDoc(Model model, @PathVariable long order_number) {

        if (invoiceService.findInvoiceByorderNumber(order_number).isPresent())
        {
            model.addAttribute("invoice", invoiceService.findInvoiceByorderNumber2(order_number));
            return "docInvoice";

        }
        else {
//            model.addAttribute("faktura", "Brak dokumentów");
            return "redirect:/order/"+ order_number;
        }

    }

    @PostMapping("/order/invoice")
    public String invoiceFormPost (@Valid @ModelAttribute Invoice invoice, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "formInvoice";
        }

        if (invoiceService.findInvoiceByorderNumber(invoice.getOrder_number()).isPresent())
        {
            model.addAttribute("faktura", "Faktura jest już wystawiona");
            return "formInvoice";

        }
        else {
            invoiceService.save(invoice);
        }


        return "redirect:/order/"+ invoice.getOrder_number();
    }



}
