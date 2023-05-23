package com.unicauca.openmarket.presentation.rest;

import com.unicauca.openmarket.domain.entity.Product;
import com.unicauca.openmarket.domain.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private IProductService productService;

    @RequestMapping(method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public List<Product> findAll(){
        return (List<Product>) productService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id){
        return productService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST,produces ="application/json")
    @ResponseBody
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT,produces="application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id){
        return productService.update(id, product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,produces= "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}
