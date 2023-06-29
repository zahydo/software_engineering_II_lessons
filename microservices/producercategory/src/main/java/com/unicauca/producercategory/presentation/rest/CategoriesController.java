package com.unicauca.producercategory.presentation.rest;

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

import com.unicauca.producercategory.domain.service.ICategoryService;
import com.unicauca.producercategory.domain.entity.Category;

@RestController
@RequestMapping("categories")
public class CategoriesController {
    @Autowired
    private ICategoryService categoryService;

    /**
     * Busca todas las categorias
     * 
     * @return Lista de categorias
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll() {
        return (List<Category>) categoryService.findAll();
    }

    /**
     * Busca un categoria por su id
     * 
     * @param id id del categoria
     * @return categoria
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id) {
        return categoryService.find(id);
    }

    /**
     * Crea un categoria
     * 
     * @param category categoria a crear
     * @return categoria creada
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }

    /**
     * Actualiza un categoria
     * 
     * @param category categoria a actualizar
     * @param id       id del categoria a actualizar
     * @return categoria eliminada
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id) {
        return categoryService.update(id, category);
    }

    /**
     * Elimina un categoria
     * 
     * @param id id del categoria a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
