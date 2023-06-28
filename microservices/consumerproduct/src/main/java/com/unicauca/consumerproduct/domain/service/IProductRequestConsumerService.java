package com.unicauca.consumerproduct.domain.service;

import com.unicauca.consumerproduct.domain.entity.ProductEvent;

public interface IProductRequestConsumerService {
	public void sendProductRequest(ProductEvent product);
}
