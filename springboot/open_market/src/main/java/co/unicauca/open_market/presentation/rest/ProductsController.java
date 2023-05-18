package co.unicauca.open_market.presentation.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	public Product find(Long id) {
		return productService.find(id);
	}


    @RequestMapping(method=RequestMethod.POST)
    public Product create(Product product) {
        return productService.create(product);
    }
    

    @RequestMapping(value="{id}", method=RequestMethod.PUT)
    public Product update(Long id, Product product) {
        return productService.update(id, product);
    }
    
    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public Product delete(Long id) {
        return productService.delete(id);
    }

}
