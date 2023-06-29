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

import com.sahydo.openmarketapp.domain.service.ICategoryEventService;
import com.sahydo.openmarketapp.presentation.rest.exception.ResourceNotFoundException;
import com.sahydo.openmarketapp.domain.model.CategoryEvent;
import com.sahydo.openmarketapp.domain.model.wrapper.CategoryRequestWrapper;
import com.sahydo.openmarketapp.presentation.rest.exception.OpenmarketErrorDomainException;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * @author Santiago Hyun
 */

@RestController
@RequestMapping("categoryRequests")
public class CategoryRequestController {
	@Autowired
	private ICategoryEventService categoryRequestService;

	/**
	 * 
	 * @return list of Category Requests
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public HttpEntity<List<CategoryRequestWrapper>> findAll() {
		List<CategoryRequestWrapper> categoryRequests = new ArrayList<>();
		categoryRequestService.findAll().stream().forEach(br -> {
			CategoryRequestWrapper wrapper = new CategoryRequestWrapper(br);
			try {
				wrapper.add(linkTo(methodOn(CategoryRequestController.class).findById(br.getId())).withSelfRel());
			} catch (ResourceNotFoundException e) {
				e.printStackTrace();
			}
			categoryRequests.add(wrapper);
		});
		return new ResponseEntity<>(categoryRequests, HttpStatus.OK);
	}

	/**
	 * get a Category Request by Id
	 * 
	 * @param id
	 * @return CategoryEvent JSON
	 * @throws Exception
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public HttpEntity<CategoryRequestWrapper> findById(@PathVariable Long id) throws ResourceNotFoundException {
		CategoryEvent categoryRequest = categoryRequestService.findById(id);
		CategoryRequestWrapper wrapper = new CategoryRequestWrapper(categoryRequest);
		wrapper.add(linkTo(methodOn(CategoryRequestController.class).findById(id)).withSelfRel());
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}

	/**
	 * Creates a CategoryEvent
	 * 
	 * @param CategoryEvent JSON
	 * @return CategoryRequesto JSON
	 * @throws ResourceNotFoundException
	 */

	@RequestMapping(method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public HttpEntity<CategoryRequestWrapper> create(@RequestBody CategoryEvent categoryRequest)
			throws OpenmarketErrorDomainException, ResourceNotFoundException {
		CategoryEvent categoryRequestCreated = categoryRequestService.create(categoryRequest);
		CategoryRequestWrapper wrapper = new CategoryRequestWrapper(categoryRequestCreated);
		wrapper.add(
				linkTo(methodOn(CategoryRequestController.class).findById(categoryRequestCreated.getId()))
						.withSelfRel());
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}
}
