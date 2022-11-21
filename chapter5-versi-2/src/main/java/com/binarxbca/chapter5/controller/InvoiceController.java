package com.binarxbca.chapter5.controller;

import com.binarxbca.chapter5.model.Invoice;
import com.binarxbca.chapter5.payload.request.InvoiceRequest;
import com.binarxbca.chapter5.service.InvoiceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/chapter5/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/add")
    public ResponseEntity<Invoice> addInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return invoiceService.addInvoice(invoiceRequest);
    }

    @PostMapping("/buy_ticket")
    public String saveTransaction(@RequestBody Invoice invoice) throws JsonProcessingException {
        invoiceService.doTransaction(invoice);

        return "Transaction has been made. Thank you!";
    }

    @GetMapping("/generate")
    public void generateInvoice(HttpServletResponse httpServletResponse,
                                  @RequestParam(value = "id") Long id) {
        invoiceService.generateInvoice(httpServletResponse, id);
    }

    @GetMapping("/download")
    public ResponseEntity downloadFile(@RequestParam("id") Long id) {
        Invoice invoice = invoiceService.downloadInvoice(id);
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_PDF);

        return ResponseEntity.ok().headers(headers).body(invoice.getFile());
    }
}
