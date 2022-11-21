package com.binarxbca.chapter5.payload.request;

import lombok.Data;

@Data
public class InvoiceRequest {
    private String buyTicketDate;
    private Double grandTotal;
    private String fileName;
}
