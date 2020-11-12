package com.alican.exceptions.exception;

public class DeliveryNotFoundException extends RuntimeException {

    public DeliveryNotFoundException() {
        super("Delivery not found!!!");
    }
}
