package com.unicauca.openmarket.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.unicauca.openmarket.domain.entity.Product;
import com.unicauca.openmarket.domain.service.IProductService;

@RestController
@RequestMapping("products")
public class ProductsController {
    
    @Autowired
    private IProductService productService;

    /**
     * Listar todos los productos
     * @return Listado de productos en JSON
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Product> findAll(){
        System.out.println("Entra al findAll");
        return (List<Product>) productService.findAll();
    }
    
    /**
     * Listar un producto por id
     * @param id identificador del producto 
     * @return producto en formato JSON
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id){
        Product product = productService.find(id);
        return product;
    } 

    /**
     * Crear un producto
     * @param product producto
     * @return producto creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    /**
     * Editar
     * @param product producto a editar
     * @param id      identificador del producto
     * @return producto editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable Long id){
        return productService.update(id, product);
    }

    /**
     * Eliminar
     * @param id id del producto
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping (value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        productService.delete(id);
    }
}