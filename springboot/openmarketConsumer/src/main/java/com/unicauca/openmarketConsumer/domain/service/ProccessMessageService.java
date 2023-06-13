package com.unicauca.openmarketConsumer.domain.service;

import org.springframework.stereotype.Service;

import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;

@Service
public class ProccessMessageService {

    private IActionProductsService actionsService;

    private ActionProducts actProduct;

    public ProccessMessageService(IActionProductsService actionsService){
        this.actionsService = actionsService;
    }
       
    public void procesarMensaje (String mensaje){
        
        String [] split = mensaje.split(",");
        String action = split[0];
        Long id = Long.parseLong(split[1]);
        String name = split[2];
        Double price = Double.parseDouble(split[3]);
        this.actProduct = new ActionProducts(id,name,price,action);
        
        switch (action) {
            case "POST":
                this.actionsService.create(actProduct);
                break;
            case "PUT":
                this.actionsService.update(id,actProduct);
                break;
            case "DELETE":
                this.actionsService.delete(id);
                break;
            default:
                System.out.println("Error! Action not found");
                break;
        }
    }
}

