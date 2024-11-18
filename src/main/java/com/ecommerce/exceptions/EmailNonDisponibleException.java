package com.ecommerce.exceptions;

public class EmailNonDisponibleException extends RuntimeException{
	
	public EmailNonDisponibleException(String message) {
        super(message);
    }
}
