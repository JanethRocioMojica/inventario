package com.misiontic4E2.inventory_ms.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Sell {
    @Id
    private String id;

    private String productIdSell;
    private Integer value;
    private Date date;

    public Sell (String id, String productIdSell,Integer value, Date date) {
        this.id = id;
        this.productIdSell = productIdSell;
        this.value = value;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductIdSell() {
        return productIdSell;
    }

    public void setProductIdSell(String productIdSell) {
        this.productIdSell = productIdSell;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}