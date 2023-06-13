package com.unicauca.openmarketProducer.presentation.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.unicauca.openmarketProducer.domain.service.IProductService;
import com.unicauca.openmarketProducer.domain.service.OpenMarketRMQProducer;
import com.unicauca.openmarketProducer.domain.entity.Product;

@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
    private IProductService productService;
    private OpenMarketRMQProducer productProducer = new OpenMarketRMQProducer();

    /**
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> findAll() {
        return (List<Product>) productService.findAll();
    }

    /**
     * Busca un producto por su id
     * 
     * @param id id del producto
     * @return producto
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id) {
        return productService.find(id);
    }

    /**
     * Crea un producto
     * 
     * @param product producto a crear
     * @return producto creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        try {
            productProducer.sendMessage("POST", product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productService.create(product);
    }

    /**
     * Actualiza un producto
     * 
     * @param product producto a actualizar
     * @param id      id del producto a actualizar
     * @return producto eliminado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id) {

        Product Product = findById(id);
        try {
            productProducer.sendMessage("PUT", Product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productService.update(id, product);
    }

    /**
     * Elimina un producto
     * 
     * @param id id del producto a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        Product product = findById(id);
        try {
            productProducer.sendMessage("DELETE", product);
        } catch (Exception e) {
            e.printStackTrace();
        }
        productService.delete(id);
    }
}
