package com.unicauca.consumerproduct.utilities;

public class ProductRequestsConstants {
	public static final String DIRECT_EXCHANGE_NAME = "productrequest-direct-exchange";
	public static final String DEAD_LETTER_EXCHANGE_NAME = "deadLetterExchange";
	public static final String DEAD_LETTER_ROUTING_KEY_NAME = "deadLetter";
	public static final String QUEUE_NAME = "openmarketrequest";
	public static final String OPENMARKET_REQUEST_ENDPOINT = "/productRequests";
	public static final String OPENMARKET_API_URL = (System.getenv("OPENMARKET_API_URL") != null
			? System.getenv("OPENMARKET_API_URL")
			: "http://localhost:8084") + OPENMARKET_REQUEST_ENDPOINT;

}