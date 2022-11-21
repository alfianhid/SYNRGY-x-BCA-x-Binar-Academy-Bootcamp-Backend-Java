package com.binarxbca.chapter5.service;

import com.binarxbca.chapter5.model.Invoice;
import com.binarxbca.chapter5.payload.request.InvoiceRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;

public interface InvoiceService {
    ResponseEntity<Invoice> addInvoice(InvoiceRequest invoiceRequest);
    void doTransaction(Invoice invoice) throws JsonProcessingException;
    void generateInvoice(HttpServletResponse response, Long id);
    Invoice downloadInvoice(Long id);
}