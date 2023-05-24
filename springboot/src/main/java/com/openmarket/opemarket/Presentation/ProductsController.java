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

import com.openmarket.opemarket.domain.Service.IProductService;
import com.openmarket.opemarket.domain.model.Product;

import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("products")
public class ProductsController {

    @Autowired
	private IProductService productService;
    
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> findAll() {
        System.out.println("Entra al findAll");
		return (List<Product>) productService.findAll();
	}
        
    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public Product findById(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public boolean edit(@RequestBody Product product, @PathVariable Long id) {

        return productService.edit(id, product);
    }
}
