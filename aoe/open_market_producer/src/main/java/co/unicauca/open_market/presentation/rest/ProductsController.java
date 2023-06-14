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

import co.unicauca.open_market.domain.entity.Product;
import co.unicauca.open_market.domain.service.IProductService;


@RestController
@RequestMapping("products")
public class ProductsController {
    @Autowired
	private IProductService productService;

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<Product> findAll() {
		return (List<Product>) productService.findAll();
	}

    
    @RequestMapping(value="{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Product find(@PathVariable Long id) {
		return productService.find(id);
	}


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public Product create(@RequestBody Product product) {
        System.out.println("Product send: " + product.toString());
        return productService.create(product);
    }
    

    @RequestMapping(value="{id}", method=RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public Product update(@PathVariable Long id, @RequestBody Product product) {
        return productService.update(id, product);
    }
    
    @RequestMapping(value="{id}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Product delete(@PathVariable Long id) {
        return productService.delete(id);
    }

}
