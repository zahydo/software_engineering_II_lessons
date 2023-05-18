package co.unicauca.open_market.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public Category find(Long id) {
		return categoryService.find(id);
	}

    @RequestMapping(method=RequestMethod.POST)
    public Category create(Category category) {
        return categoryService.create(category);
    }
    

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Category update(Long id, Category category) {
        return categoryService.update(id, category);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public Category delete(Long id) {
        return categoryService.delete(id);
    }
}
