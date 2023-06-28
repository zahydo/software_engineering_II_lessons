package com.sahydo.openmarketapp.domain.model.wrapper;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sahydo.openmarketapp.domain.model.CategoryEvent;

public class CategoryRequestWrapper extends RepresentationModel<CategoryRequestWrapper> {
	private final CategoryEvent categoryRequest;

	@JsonCreator
	public CategoryRequestWrapper(@JsonProperty("categoryRequest") CategoryEvent categoryRequest) {
		this.categoryRequest = categoryRequest;
	}

	public CategoryEvent getOpenmarketRequest() {
		return categoryRequest;
	}
}
