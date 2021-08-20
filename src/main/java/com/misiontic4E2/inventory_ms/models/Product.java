package com.misiontic4E2.inventory_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Product {
    @Id
    private String productId;

    private Integer quantity;
    private Date lastChange;

    public Product(String productId, Integer quantity, Date lastChange) {
        this.productId = productId;
        this.quantity = quantity;
        this.lastChange = lastChange;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Date getLastChange() {
        return lastChange;
    }

    public void setLastChange(Date lastChange) {
        this.lastChange = lastChange;
    }
}