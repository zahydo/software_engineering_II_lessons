package com.unicauca.openmarket.presentation.rest;

import com.unicauca.openmarket.domain.entity.Category;
import com.unicauca.openmarket.domain.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("categories")
public class CategoriesController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET,produces="application/json")
    public List<Category> findAll(){
        return (List<Category>) categoryService.findAll();
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET,produces="application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id){
        return categoryService.find(id);
    }

    @RequestMapping(method = RequestMethod.POST,produces="application/json")
    public Category create(@RequestBody Category category){
        return categoryService.create(category);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT,produces="application/json")
    @ResponseBody
    public Category update(@RequestBody Category category, @PathVariable Long id){
        return categoryService.update(id, category);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE,produces="application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        categoryService.delete(id);
    }
}
