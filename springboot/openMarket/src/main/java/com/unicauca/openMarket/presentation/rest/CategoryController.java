package com.unicauca.openMarket.presentation.rest;

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

import com.unicauca.openMarket.domain.entity.Category;
import com.unicauca.openMarket.domain.service.ICategoryService;

/**
 * @author nimbachi
 */

@RestController
@RequestMapping("categories")

public class CategoryController {
    
    @Autowired
    private ICategoryService categoryService;

    /**
     * Listar todas las categorias
     * @return Listado de prooducto en archivo Json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Category> findAll(){
        System.out.println("Entra al findAll");
        return (List<Category>) categoryService.findAll();
    }

    /**
     * Buscar una categoria con un respectivo Id
     * @param id Identificador de la categoria
     * @return Ctegoria encontrada
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id){
        Category cat = categoryService.find(id);
        return cat;
    }

    /**
     * Crear una nueva categoria
     * @param category Categoria que contiene los datos
     * @return Categoria creada
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    /**
     * Editar una categoria
     * @param category Categoria con nueva informacion
     * @param id Identificador de la categroria a modificar
     * @return Categoria modificada
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id){
        return categoryService.update(id, category);
    }

    /**
     * Eliminar una categoria con un id especifico
     * @param id Identificador de la categoria a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }

}
