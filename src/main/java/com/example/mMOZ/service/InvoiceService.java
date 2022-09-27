package com.example.mMOZ.service;

import com.example.mMOZ.Entity.Invoice;
import com.example.mMOZ.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }


    public void save(Invoice invoice) {
        invoice.setCreate_data(String.valueOf(LocalDateTime.now()));
        invoice.setStatus(1);
        invoiceRepository.save(invoice);
    }

    public Invoice findInvoiceByorderNumber(Long order_number) {
        return invoiceRepository.findInvoiceByOrder_number(order_number);
    }

    public List<Integer> findInvoiceByorderNumberDoc(List<Long> order_number) {
        return invoiceRepository.findInvoiceByOrder_numberNumberDoc(order_number);
    }

}
