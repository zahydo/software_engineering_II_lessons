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

import com.unicauca.openmarket.domain.entity.Category;
import com.unicauca.openmarket.domain.service.ICategoryService;

@RestController
@RequestMapping("categories")
public class CategoriesController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * Listar todas las categorias
     * @return Listado de categorias en JSON
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll(){
        System.out.println("Category - findAll");
        return (List<Category>) categoryService.findAll();
    }
    
    /**
     * Listar un categoria por id
     * @param id identificador del categoria 
     * @return categoria en formato JSON
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id){
        System.out.println("Category - findById");
        return categoryService.find(id);
    } 

    /**
     * Crear un categoria
     * @param category categoria
     * @return categoria creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category){
        System.out.println("Category - create");
        return categoryService.create(category);
    }

    /**
     * Editar
     * @param category categoria a editar
     * @param id      identificador del categoria
     * @return categoria editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id){
        System.out.println("Category - update");
        return categoryService.update(id, category);
    }

    /**
     * Eliminar
     * @param id id del categoria
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping (value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        System.out.println("Category - delete");
        categoryService.delete(id);
    }
}