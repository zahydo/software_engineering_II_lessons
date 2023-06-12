package com.unicauca.openmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.unicauca.openmarket.domain.service.OpenMarketRMQProducer;

@SpringBootApplication
public class OpenmarketApplication {
	private final OpenMarketRMQProducer OMProducer;

	@Autowired
    public OpenmarketApplication(OpenMarketRMQProducer OMProducer) {
        this.OMProducer = OMProducer;
    }

	public static void main(String[] args) {
		SpringApplication.run(OpenmarketApplication.class, args);
	}

}
