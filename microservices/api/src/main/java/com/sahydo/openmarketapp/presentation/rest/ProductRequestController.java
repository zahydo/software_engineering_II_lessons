package com.sahydo.openmarketapp.presentation.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sahydo.openmarketapp.domain.service.IProductEventService;
import com.sahydo.openmarketapp.presentation.rest.exception.ResourceNotFoundException;
import com.sahydo.openmarketapp.domain.model.ProductEvent;
import com.sahydo.openmarketapp.domain.model.wrapper.ProductRequestWrapper;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketErrorDomainException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @author Santiago Hyun
 */

@RestController
@RequestMapping("productRequests")
public class ProductRequestController {
	@Autowired
	private IProductEventService productRequestService;

	/**
	 * 
	 * @return list of Product Requests
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public HttpEntity<List<ProductRequestWrapper>> findAll() {
		List<ProductRequestWrapper> productRequests = new ArrayList<>();
		productRequestService.findAll().stream().forEach(br -> {
			ProductRequestWrapper wrapper = new ProductRequestWrapper(br);
			try {
				wrapper.add(linkTo(methodOn(ProductRequestController.class).findById(br.getId())).withSelfRel());
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
			productRequests.add(wrapper);
		});
		return new ResponseEntity<>(productRequests, HttpStatus.OK);
	}

	/**
	 * get a Product Request by Id
	 * 
	 * @param id
	 * @return ProductEvent JSON
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public HttpEntity<ProductRequestWrapper> findById(@PathVariable Long id) throws ResourceNotFoundException {
		ProductEvent openmarketRequest = productRequestService.findById(id);
		ProductRequestWrapper wrapper = new ProductRequestWrapper(openmarketRequest);
		wrapper.add(linkTo(methodOn(ProductRequestController.class).findById(id)).withSelfRel());
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}

	/**
	 * Creates a ProductEvent
	 * 
	 * @param ProductEvent JSON
	 * @return ProductRequesto JSON
	 * @throws ResourceNotFoundException
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public HttpEntity<ProductRequestWrapper> create(@RequestBody ProductEvent openmarketRequest)
			throws OpenmarketErrorDomainException, ResourceNotFoundException {
		ProductEvent openmarketRequestCreated = productRequestService.create(openmarketRequest);
		ProductRequestWrapper wrapper = new ProductRequestWrapper(openmarketRequestCreated);
		wrapper.add(
				linkTo(methodOn(ProductRequestController.class).findById(openmarketRequestCreated.getId()))
						.withSelfRel());
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}
}
