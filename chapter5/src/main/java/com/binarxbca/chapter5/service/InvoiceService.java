package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.invoice.Invoice;

import java.util.List;

public interface InvoiceService {
    public Invoice addInvoice(Invoice invoice);
    public Invoice getInvoiceById(String id);
    public List<Invoice> getAllInvoices();
    public void deleteInvoice(String id);
    public Invoice downloadInvoice(String id);
}
