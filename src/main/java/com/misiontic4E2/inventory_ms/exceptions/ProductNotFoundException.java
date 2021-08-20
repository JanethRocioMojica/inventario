package com.misiontic4E2.inventory_ms.exceptions;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}