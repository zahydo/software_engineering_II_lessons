package com.unicauca.consumerproduct.domain.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.unicauca.consumerproduct.domain.entity.ProductEvent;
import com.unicauca.consumerproduct.utilities.ProductRequestsConstants;

@Service
public class ProductRequestConsumerImplService implements IProductRequestConsumerService {

	@Override
	public void sendProductRequest(ProductEvent product) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JsonObject json = new JsonObject();
		json.addProperty("name", product.getName());
		json.addProperty("price", product.getPrice());
		json.addProperty("action", product.getAction());
		json.addProperty("holderEmail", product.getHolderEmail() != null ? product.getHolderEmail() : "");
		HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);

		// send request and parse result
		ResponseEntity<String> response = restTemplate.exchange(ProductRequestsConstants.OPENMARKET_API_URL,
				HttpMethod.POST, entity, String.class);
		System.out.println(response);
	}

}
