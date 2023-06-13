package com.unicauca.openmarketConsumer.presentation.rest;

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

import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;
import com.unicauca.openmarketConsumer.domain.service.IActionProductsService;

@RestController
@RequestMapping("actionProducts")
public class ActionProductsController {

    @Autowired
    private IActionProductsService actProductService;

    /**
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ActionProducts> findAll(){
        return(List<ActionProducts>) actProductService.findAll();
    }    

    /**
     * Busca un producto por su id
     * 
     * @param id id del producto
     * @return producto
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public ActionProducts findById(@PathVariable Long id) {
        return actProductService.find(id);
    }

    /**
     * Crea un producto
     * 
     * @param actProduct producto a crear
     * @return producto creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public ActionProducts create(@RequestBody ActionProducts actProduct) {
        return actProductService.create(actProduct);
    }

    /**
     * Actualiza un producto
     * 
     * @param actProduct producto a actualizar
     * @param id      id del producto a actualizar
     * @return producto eliminado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public ActionProducts update(@RequestBody ActionProducts actProduct, @PathVariable Long id) {
        return actProductService.update(id, actProduct);
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
        actProductService.delete(id);
    }
}
