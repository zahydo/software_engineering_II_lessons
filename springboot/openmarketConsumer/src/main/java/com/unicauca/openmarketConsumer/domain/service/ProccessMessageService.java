package com.unicauca.openmarketConsumer.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;

public class ProccessMessageService {
    
    @Autowired
    private IActionProductsService actProductService;

    String action = "";
    ActionProducts actProduct = new ActionProducts();
    
    
       
    public void procesarMensaje (String mensaje){

        String [] split = mensaje.split(",");
        
        switch (split[0]) {
        case "POST":
            actProductService.create(actProduct);
            
            break;
        case "PUT":
            
            break;
        case "DELETE":
            break;
            
        default:
            break;
    }
    }
}

