package com.unicauca.openMarket.presentation.rest;

import com.unicauca.openMarket.domain.entity.Product;
import com.unicauca.openMarket.domain.service.IProductService;
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

@RestController
@RequestMapping("products")


public class ProductController {

    @Autowired
    private IProductService productService;

    /**
     * Listar productos en json
     * @return Listado de productos
     */
    @RequestMapping(method = RequestMethod.GET, produces =  "application/json")
    @ResponseBody
    public List<Product> findAll(){
        System.out.println("Entra al findAll");
        return (List<Product>)  productService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces =  "application/json")
    @ResponseBody
    public Product findById(@PathVariable long id){
        Product prod = productService.find(id);
        return prod; 
    }


    /**
     * Crear un product
     * @param product producto
     * @return  producto creado
     */
    @RequestMapping(method = RequestMethod.POST, produces =  "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    /**
     * Editar
     * @param product Producto con nueva informacion
     * @param id identificador del producto
     * @return producto editado. 
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces =  "application/json")
    @ResponseBody
    public Product update(@RequestBody Product product, @PathVariable long id){
        Product prod = productService.update(id, product);
        return prod; 
    }

    /**
     * Eliminar
     * @param id identificador del producto a eliminar.  
     */

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces =  "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable long id){
        productService.delete(id);
    }


}
