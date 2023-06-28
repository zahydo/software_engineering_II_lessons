package com.unicauca.consumercategory.domain.service;

import com.unicauca.consumercategory.domain.entity.CategoryEvent;

public interface ICategoryRequestConsumerService {
	public void sendCategoryRequest(CategoryEvent category);
}
