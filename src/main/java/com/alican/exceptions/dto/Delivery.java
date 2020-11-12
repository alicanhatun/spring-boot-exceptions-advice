package com.alican.exceptions.dto;

import java.io.Serializable;

public class Delivery implements Serializable {

    private String barcode;
    private String status;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
