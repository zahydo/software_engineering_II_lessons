package co.unicauca.open_market.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import co.unicauca.open_market.domain.entity.Category;
import co.unicauca.open_market.domain.service.ICategoryService;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Category> findAll() {
		return (List<Category>) categoryService.findAll();
	}

    
    @RequestMapping(value="{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Category find(@PathVariable Long id) {
		return categoryService.find(id);
	}

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Category create(@RequestBody Category category) {
        return categoryService.create(category);
    }
    

    @RequestMapping(value="{id}", method=RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Category update(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.update(id, category);
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Category delete(Long id) {
        return categoryService.delete(id);
    }
}
