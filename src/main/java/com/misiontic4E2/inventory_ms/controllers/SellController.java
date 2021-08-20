package com.misiontic4E2.inventory_ms.controllers;


import com.misiontic4E2.inventory_ms.exceptions.ProductNotFoundException;
import com.misiontic4E2.inventory_ms.models.Product;
import com.misiontic4E2.inventory_ms.models.Sell;
import com.misiontic4E2.inventory_ms.repositories.ProductRepository;
import com.misiontic4E2.inventory_ms.repositories.SellRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class SellController {

    private final ProductRepository productRepository;
    private final SellRepository sellRepository;

    public SellController(ProductRepository productRepository, SellRepository sellRepository) {
        this.productRepository = productRepository;
        this.sellRepository = sellRepository;
    }

    @PostMapping("/sells")
    Sell newSell(@RequestBody Sell sell){
        Product productIdSell = productRepository.findById(sell.getProductIdSell()).orElse(null);

        if (productIdSell == null)
            throw new ProductNotFoundException("No se encontró el producto : " + sell.getProductIdSell());

        productIdSell.setQuantity(productIdSell.getQuantity() - sell.getValue());
        productIdSell.setLastChange(new Date());
        productRepository.save(productIdSell);

        sell.setDate(new Date());
        return sellRepository.save(sell);

    }

    @GetMapping("/sells/{productId}")
    List<Sell> productSell (@PathVariable String productId){
        Product idProduct = productRepository.findById(productId).orElse(null);
        if (idProduct == null)
            throw new ProductNotFoundException("No se encontró el producto : " + productId);

        List<Sell> sellsId = sellRepository.findByProductIdSell(productId);

        List<Sell> sells = sellsId.stream().collect(Collectors.toList());

        return sells;
    }


}