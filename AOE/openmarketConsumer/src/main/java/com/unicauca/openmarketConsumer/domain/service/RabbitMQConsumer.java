
package com.unicauca.openmarketConsumer.domain.service;


import org.springframework.stereotype.Service;

import com.unicauca.openmarketConsumer.domain.entity.Product;

@Service
public class RabbitMQConsumer {

    private IProductEventService actionsService;

    public RabbitMQConsumer(IProductEventService actionsService){
        this.actionsService = actionsService;
    }
       
    public void procesarMensaje (String mensaje){
        
        String [] split = mensaje.split(",");
        String action = split[0];
        Long id = Long.parseLong(split[1]);
        String name = split[2];
        Double price = Double.parseDouble(split[3]);
        Product producto = new Product();
        producto.setId(id);
        producto.setName(name);
        producto.setPrice(price);
        
        switch (action) {
            case "POST":
                this.actionsService.create(producto);
                break;
            case "PUT":
                this.actionsService.update(id,producto);
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
