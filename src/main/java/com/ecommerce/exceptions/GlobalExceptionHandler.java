package com.ecommerce.exceptions;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ecommerce.utils.FonctionsUtiles;

@ControllerAdvice
public class GlobalExceptionHandler {
	@Autowired
	private FonctionsUtiles functions;

	// ERREUR REPONSE QUAND EMAIL EXISTANT
    @ExceptionHandler(EmailNonDisponibleException.class)
    @ResponseStatus(HttpStatus.CONFLICT)			// CONFLICT création de ressource avec des données déjà existantes.
    public ResponseEntity<Map<String, String>> handleEmailNonDisponibleException(EmailNonDisponibleException ex) {
		
		
        return ResponseEntity.status(HttpStatus.CONFLICT)
        						.body(functions.response_error(ex.getMessage()));
    }
    
    // Erreur quand findById ne retourne aucun objet
    @ExceptionHandler(NoSuchElementException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)			// NOT FOUND Ressource demandée introuvable.
    public ResponseEntity<Map<String, String>> handleNoSuchElementException(NoSuchElementException ex) {
    	
		
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        						.body(functions.response_error(ex.getMessage()));
    }
    
//    // Erreur non classifié
//    @ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.NOT_FOUND)			// NOT FOUND Ressource demandée introuvable.
//    public ResponseEntity<Map<String, String>> Exception(Exception ex) {
//    	
//		
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
//        						.body(functions.reponse(TYPE_ERROR,ex.getMessage()));
//    }
}
