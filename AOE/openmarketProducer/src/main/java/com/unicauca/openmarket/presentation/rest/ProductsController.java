/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.presentation.rest;

import com.unicauca.openmarket.domain.entity.Product;
import com.unicauca.openmarket.service.IProductService;
import java.util.List;
import static org.hibernate.criterion.Projections.id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author brayan
 */
@RestController//para que seaa un componente en spring boot
@RequestMapping("products")//mapea las peticiones que llega a products

public class ProductsController {
    @Autowired
    private IProductService productService;
    
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    @ResponseBody//para que se convierta a json
    public List<Product>findAll(){
        System.out.println("entra al findAll");
        return (List<Product>)productService.findAll();  
    }
    
    
    @RequestMapping(value ="{id}" ,method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id){
        Product product=productService.find(id);
        return product;
    }
    
   
    @RequestMapping(method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public  Product create(@RequestBody Product product ){
        return productService.create(product);
    }
    @RequestMapping(value="{id}",method=RequestMethod.PUT, produces="application/json")
    @ResponseBody
    public Product update(@RequestBody Product product,@PathVariable Long id){
        return productService.update(id, product);
    }
    @RequestMapping(value="{id}",method=RequestMethod.DELETE, produces="application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
    
    
}
