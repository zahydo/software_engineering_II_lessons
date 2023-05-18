package com.unicauca.openmarket.presentation.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unicauca.openmarket.domain.entity.Category;
import com.unicauca.openmarket.domain.service.ICategoryService;

@RestController // Para que sea un componente de spring
@RequestMapping("categorys") // Mapea las peticiones que lleguen a /category
public class CategorysController {

    @Autowired
    private ICategoryService categoryService;

    /**
     * Listar todos
     * 
     * @return Listado de categorias en json
     */
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Category> findAll() {
        System.out.println("Entra al findAll");
        return (List<Category>) categoryService.findAll();
    }

    /**
     * Listar un categoria por su id
     * 
     * @param id identificador del categoria
     * @return categoria en formato json
     * @throws Exception
     */
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id) {
        System.out.println("Entra al findById");
        Category category = categoryService.find(id);
        return category;
    }

    /**
     * Crear un nuevo categoria
     * 
     * @param category categoria
     * @return categoria creado
     */
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) {
        System.out.println("Entra al create");
        return categoryService.create(category);
    }

    /**
     * Editar
     * 
     * @param category categoria a editar
     * @param id       identificador del categoria
     * @return categoria editado
     * @throws ResourceNotFoundException recurso no encontrado
     * @throws Exception                 id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id) {
        System.out.println("Entra al update");
        return categoryService.update(id, category);
    }

    /**
     * Eliminar
     * 
     * @param id id del categoria
     * @throws ResourceNotFoundException id no encontrado
     */
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        System.out.println("Entra al delete");
        categoryService.delete(id);
    }
}