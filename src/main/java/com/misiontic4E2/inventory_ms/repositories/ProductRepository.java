package com.misiontic4E2.inventory_ms.repositories;

import com.misiontic4E2.inventory_ms.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository <Product, String> {
}
