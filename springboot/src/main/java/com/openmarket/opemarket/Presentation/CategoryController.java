package com.openmarket.opemarket.Presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.openmarket.opemarket.domain.Service.ICategoryService;
import com.openmarket.opemarket.domain.model.Category;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("categories")
public class CategoryController {
       @Autowired
	private ICategoryService categoryService;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Category> findAll() {
        System.out.println("Entra al findAll");
		return (List<Category>) categoryService.findAll();
	}
        
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Category findById(@PathVariable Long id){
        return this.categoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        categoryService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public boolean edit(@RequestBody Category category, @PathVariable Long id) {

        return categoryService.edit(id, category);
    }
    
}
