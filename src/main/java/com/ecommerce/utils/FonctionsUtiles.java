package com.ecommerce.utils;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class FonctionsUtiles {
	
	private final String TYPE_MESSAGE = "message";
	
	private final String TYPE_ERROR = "error";
	

	public Map<String, String> response_message(String message){
		Map<String, String> reponse = new HashMap<>();
		reponse.put(TYPE_MESSAGE, message);
        
        return reponse;
	}
	
	public Map<String, String> response_error(String message){
		Map<String, String> reponse = new HashMap<>();
		reponse.put(TYPE_ERROR, message);
        
        return reponse;
	}
	
}
