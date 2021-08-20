package com.misiontic4E2.inventory_ms.models;


import org.springframework.data.annotation.Id;

import java.util.Date;

public class Buy{
    @Id
    private String id;

    private String productIdBuy;
    private Integer value;
    private Date date;

    public Buy(String id, String productIdBuy,Integer value, Date date) {
        this.id = id;
        this.productIdBuy = productIdBuy;
        this.value = value;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductIdBuy() {
        return productIdBuy;
    }

    public void setProductIdBuy(String productIdBuy) {
        this.productIdBuy = productIdBuy;
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