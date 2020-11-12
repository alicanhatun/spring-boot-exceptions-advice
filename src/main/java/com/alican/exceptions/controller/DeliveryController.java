package com.alican.exceptions.controller;

import com.alican.exceptions.dto.Delivery;
import com.alican.exceptions.exception.DeliveryNotFoundException;
import com.alican.exceptions.exception.DeliverySaveException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    @GetMapping
    public String getDelivery() {
        throw new DeliveryNotFoundException();
    }

    @PostMapping
    public Delivery postDelivery(@RequestBody Delivery delivery) {
        if (delivery.getStatus() != null) {
            throw new DeliverySaveException("Delivery can not save!!!");
        }
        return delivery;
    }


}
