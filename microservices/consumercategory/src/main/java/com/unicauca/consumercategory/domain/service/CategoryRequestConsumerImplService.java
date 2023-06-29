package com.unicauca.consumercategory.domain.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.JsonObject;
import com.unicauca.consumercategory.domain.entity.CategoryEvent;
import com.unicauca.consumercategory.utilities.CategoryRequestsConstants;

@Service
public class CategoryRequestConsumerImplService implements ICategoryRequestConsumerService {

	@Override
	public void sendCategoryRequest(CategoryEvent category) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JsonObject json = new JsonObject();
		json.addProperty("name", category.getName());
		json.addProperty("description", category.getDescription());
		json.addProperty("action", category.getAction());
		json.addProperty("holderEmail", category.getHolderEmail() != null ? category.getHolderEmail() : "");
		HttpEntity<String> entity = new HttpEntity<String>(json.toString(), headers);

		// send request and parse result
		ResponseEntity<String> response = restTemplate.exchange(CategoryRequestsConstants.OPENMARKET_API_URL,
				HttpMethod.POST, entity, String.class);
		System.out.println(response);
	}

}
