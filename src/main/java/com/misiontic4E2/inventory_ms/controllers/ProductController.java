package com.misiontic4E2.inventory_ms.controllers;

import com.misiontic4E2.inventory_ms.exceptions.ProductNotFoundException;
import com.misiontic4E2.inventory_ms.models.Product;
import com.misiontic4E2.inventory_ms.repositories.ProductRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProductController {

    private final ProductRepository productRepository;


    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;

        //Seed
        Product newProduct01 = new Product("Martillo", 10, new Date());
        Product newProduct02 = new Product("Clavo", 1000, new Date());

        this.productRepository.save(newProduct01);
        this.productRepository.save(newProduct02);
    }

    @GetMapping("/products/{productId}")
    Product getProduct(@PathVariable String productId){
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException("No se encontró el producto : " + productId));
    }
}