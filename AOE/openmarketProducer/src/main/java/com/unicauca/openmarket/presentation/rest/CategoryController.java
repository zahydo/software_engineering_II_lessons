/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.presentation.rest;

import com.unicauca.openmarket.domain.entity.Category;
import com.unicauca.openmarket.service.ICategoryService;
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

/**
 *
 * @author brayan
 */
@RestController//para que seaa un componente en spring boot
@RequestMapping("category")//mapea las peticiones que llega a products
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    
    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    @ResponseBody//para que se convierta a json
    public List<Category>findAll(){
      
        return (List<Category>)categoryService.findAll();  
    }
      @RequestMapping(value ="{id}" ,method=RequestMethod.GET, produces="application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id){
        Category category=categoryService.find(id);
        return category;
    }
     @RequestMapping(method=RequestMethod.POST, produces="application/json")
    @ResponseBody
    public  Category create(@RequestBody Category category ){
        return categoryService.create(category);
    }
    @RequestMapping(value="{id}",method=RequestMethod.PUT, produces="application/json")
    @ResponseBody
    public Category update(@RequestBody Category category,@PathVariable Long id){
        return categoryService.update(id, category);
    }
     @RequestMapping(value="{id}",method=RequestMethod.DELETE, produces="application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
    
}
