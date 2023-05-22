
package com.unicauca.openmarket.presentation.rest;

import com.unicauca.openmarket.domain.entity.Category;
import com.unicauca.openmarket.domain.service.ICategoryService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author SANTIAGO
 */
@RestController
@RequestMapping("categories")


public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    
    /**
     * Listar categorias en json
     * @return Listado de categorias
     */
    @RequestMapping(method = RequestMethod.GET, produces =  "application/json")
    @ResponseBody
    public List<Category> findAll(){
        System.out.println("Entra al findAll");
        return (List<Category>)  categoryService.findAll();
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces =  "application/json")
    @ResponseBody
    public Category findById(@PathVariable long id){
        Category prod = categoryService.find(id);
        return prod; 
    }
    
    
    /**
     * Crear un category
     * @param category categoryo
     * @return  categoryo creado
     */
    @RequestMapping(method = RequestMethod.POST, produces =  "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }
    
    /**
     * Editar
     * @param category Categoryo con nueva informacion
     * @param id identificador del categoryo
     * @return categoryo editado. 
     */
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces =  "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable long id){
        Category cat = categoryService.update(id, category);
        return cat; 
    }
    
    /**
     * Eliminar
     * @param id identificador del categoria a eliminar.  
     */
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces =  "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable long id){
        categoryService.delete(id);
    }
    

}
