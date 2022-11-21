package com.binarxbca.chapter5.service.impl;

import com.binarxbca.chapter5.model.InvoiceDetail;
import com.binarxbca.chapter5.repository.InvoiceDetailRepository;
import com.binarxbca.chapter5.service.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceDetailServiceImpl implements InvoiceDetailService {
    @Autowired
    InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public InvoiceDetail saveInvoiceDetail(InvoiceDetail invoiceDetail) {
        return invoiceDetailRepository.save(invoiceDetail);
    }
}
