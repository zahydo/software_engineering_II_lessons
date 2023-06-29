package com.sahydo.openmarketapp.domain.model.wrapper;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sahydo.openmarketapp.domain.model.ProductEvent;

public class ProductRequestWrapper extends RepresentationModel<ProductRequestWrapper> {
	private final ProductEvent productRequest;

	@JsonCreator
	public ProductRequestWrapper(@JsonProperty("productRequest") ProductEvent productRequest) {
		this.productRequest = productRequest;
	}

	public ProductEvent getOpenmarketRequest() {
		return productRequest;
	}
}
