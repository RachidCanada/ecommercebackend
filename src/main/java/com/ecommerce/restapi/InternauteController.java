package com.ecommerce.restapi;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.entities.Client;
import com.ecommerce.entities.Compte;
import com.ecommerce.entities.Produit;
import com.ecommerce.requests.RequestConnect;
import com.ecommerce.requests.RequestRegister;
import com.ecommerce.services.ServiceInternaute;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/internaute")
public class InternauteController {
	
	@Autowired
    private ServiceInternaute serviceInternaute;
	
	
	
	
	@GetMapping("/rechercher")
	public ResponseEntity<Map<Long, List<Produit>>> getAllProduitsByName(
	        								@RequestParam(required = false, defaultValue = "") 
	        								String produit) {
	    return serviceInternaute.getAllProduitsByName(produit);
	}
	
	// Inscription client
	@Transactional
	@PostMapping("/inscription-client")
	public  ResponseEntity< Client > register(@RequestBody RequestRegister request){
		
		return serviceInternaute.registerClient(request);
	}
	
	
	// Inscription admin
	@Transactional
	@PostMapping("/inscription-admin")
    public ResponseEntity<Compte> register(@RequestBody Compte compte) {		

        return serviceInternaute.registerAdmin(compte);
    }
	
	@Transactional
	@PostMapping("/connecter")
	public ResponseEntity<Map<String, String>> connect(@RequestBody RequestConnect request) {
	    
		return serviceInternaute.connect(request);
	}


}
