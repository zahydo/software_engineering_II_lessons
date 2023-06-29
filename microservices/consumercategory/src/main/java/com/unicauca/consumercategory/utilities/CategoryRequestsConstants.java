package com.unicauca.consumercategory.utilities;

public class CategoryRequestsConstants {
	public static final String DIRECT_EXCHANGE_NAME = "categoryrequest-direct-exchange";
	public static final String DEAD_LETTER_EXCHANGE_NAME = "deadLetterExchange";
	public static final String DEAD_LETTER_ROUTING_KEY_NAME = "deadLetter";
	public static final String QUEUE_NAME = "openmarketrequest";
	public static final String OPENMARKET_REQUEST_ENDPOINT = "/categoryRequests";
	public static final String OPENMARKET_API_URL = (System.getenv("OPENMARKET_API_URL") != null
			? System.getenv("OPENMARKET_API_URL")
			: "http://localhost:8084") + OPENMARKET_REQUEST_ENDPOINT;

}