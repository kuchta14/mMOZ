package com.example.mMOZ.service;

import com.example.mMOZ.Entity.Invoice;
import com.example.mMOZ.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public Optional<Invoice> findInvoiceByorderNumber(Long order_number) {
        return invoiceRepository.findInvoiceByOrder_numberTrue(order_number);
    }

    public Invoice findInvoiceByorderNumber2(Long order_number) {
        return invoiceRepository.findInvoiceByOrder_number(order_number);
    }

    public List<Integer> findInvoiceByorderNumberDoc(List<Long> order_number) {
        return invoiceRepository.findInvoiceByOrder_numberNumberDoc(order_number);
    }

}
