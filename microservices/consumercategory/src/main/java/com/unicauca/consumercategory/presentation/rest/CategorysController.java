package com.unicauca.consumercategory.presentation.rest;

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

import com.unicauca.consumercategory.domain.service.ICategoryEventService;
import com.unicauca.consumercategory.domain.entity.CategoryEvent;

@RestController
@RequestMapping("categorylogs")
public class CategorysController {
    @Autowired
    private ICategoryEventService categoryService;

    /**
     * Busca todos los categoryos
     * 
     * @return Lista de categoryos
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<CategoryEvent> findAll() {
        return (List<CategoryEvent>) categoryService.findAll();
    }

    /**
     * Busca un categoryo por su id
     * 
     * @param id id del categoryo
     * @return categoryo
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public CategoryEvent findById(@PathVariable Long id) {
        return categoryService.find(id);
    }

    /**
     * Crea un categoryo
     * 
     * @param category categoryo a crear
     * @return categoryo creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public CategoryEvent create(@RequestBody CategoryEvent category) {
        return categoryService.create(category);
    }

    /**
     * Actualiza un categoryo
     * 
     * @param category categoryo a actualizar
     * @param id       id del categoryo a actualizar
     * @return categoryo eliminado
     */

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public CategoryEvent update(@RequestBody CategoryEvent category, @PathVariable Long id) {
        return categoryService.update(id, category);
    }

    /**
     * Elimina un categoryo
     * 
     * @param id id del categoryo a eliminar
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }
}
