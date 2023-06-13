package com.unicauca.openmarketConsumer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;

public class ProccessMessageService {
    
    @Autowired
    private IActionProductsService actProductService;

    String action = "";
    ActionProducts actProducts = new ActionProducts();
    String message = action + "," +actProducts.getId() + "," 
                                  +actProducts.getName()+"," 
                                  +actProducts.getPrice();

    if(action.equals("POST")){
        actProductService.create(actProducts);
    }else if (action.equals("GET")){
        actProductService.findAll();
    }else if (action.equals("PUT")){
        actProductService.update(actProducts.getId(), actProducts);
    }else if (action.equals("DELETE")){
        actProductService.delete(actProducts.getId());
    }
}

