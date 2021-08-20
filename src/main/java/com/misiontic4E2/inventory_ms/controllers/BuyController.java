package com.misiontic4E2.inventory_ms.controllers;


import com.misiontic4E2.inventory_ms.exceptions.ProductNotFoundException;
import com.misiontic4E2.inventory_ms.models.Product;
import com.misiontic4E2.inventory_ms.models.Buy;
import com.misiontic4E2.inventory_ms.repositories.ProductRepository;
import com.misiontic4E2.inventory_ms.repositories.BuyRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class BuyController {

    private final ProductRepository productRepository;
    private final BuyRepository buyRepository;

    public BuyController(ProductRepository productRepository, BuyRepository buyRepository) {
        this.productRepository = productRepository;
        this.buyRepository = buyRepository;
    }

    @PostMapping("/buys")
    Buy newBuy(@RequestBody Buy buy){
        Product productIdBuy = productRepository.findById(buy.getProductIdBuy()).orElse(null);

        if (productIdBuy == null)
            throw new ProductNotFoundException("No se encontró el producto : " + buy.getProductIdBuy());

        productIdBuy.setQuantity(productIdBuy.getQuantity() + buy.getValue());
        productIdBuy.setLastChange(new Date());
        productRepository.save(productIdBuy);

        buy.setDate(new Date());
        return buyRepository.save(buy);

    }

    @GetMapping("/buys/{productId}")
    List<Buy> productBuy (@PathVariable String productId){
        Product idProduct = productRepository.findById(productId).orElse(null);
        if (idProduct == null)
            throw new ProductNotFoundException("No se encontró el producto : " + productId);

        List<Buy> buysId = buyRepository.findByProductIdBuy(productId);

        List<Buy> buys = buysId.stream().collect(Collectors.toList());

        return buys;
    }


}