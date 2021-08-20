package com.misiontic4E2.inventory_ms.repositories;

import com.misiontic4E2.inventory_ms.models.Sell;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SellRepository extends MongoRepository<Sell, String> {
    List<Sell> findByProductIdSell (String productIdSell);
}
