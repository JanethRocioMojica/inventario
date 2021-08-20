package com.misiontic4E2.inventory_ms.repositories;

import com.misiontic4E2.inventory_ms.models.Buy;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BuyRepository extends MongoRepository<Buy, String> {
    List<Buy> findByProductIdBuy (String productIdBuy);
}
