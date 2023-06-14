
package com.unicauca.openmarket.service;

import com.unicauca.openmarket.config.IRabbitMQConfig;
import com.unicauca.openmarket.config.RabbitMQConfig;
import com.unicauca.openmarket.domain.entity.Product;
import javax.swing.JOptionPane;



public class RabbitMQSender {
    private IRabbitMQConfig rabbitconfig;

    public RabbitMQSender() {
        this.rabbitconfig = new RabbitMQConfig();
    }
   
    
    public void send(Product product,String action){
        try{
             rabbitconfig.connection(product, action);
        }catch(Exception e){
             JOptionPane.showMessageDialog(null, "ERRO AL CONECTAR EL SERVIDOR");
        }
       
    }
}
