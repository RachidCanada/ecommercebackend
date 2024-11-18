package com.ecommerce.restapi;

import com.ecommerce.entities.Categorie;
import com.ecommerce.entities.Client;
import com.ecommerce.entities.Compte;
import com.ecommerce.entities.Produit;
import com.ecommerce.exceptions.EmailNonDisponibleException;
import com.ecommerce.requests.RequestAddProduit;
import com.ecommerce.requests.RequestRegister;
import com.ecommerce.services.ServiceAdmin;
import com.ecommerce.services.ServiceInternaute;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/admin/catalogue")
public class AdminController {
	
	@Autowired
    private ServiceAdmin serviceAdmin;
	

	// END MAP Pour les Catégories
	@GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getAllCategories() {
        
        return serviceAdmin.getAllCategories();
    }
	
	@GetMapping("/categorie/{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable Long id) {
        
        return serviceAdmin.getCategorie(id);
    }
	
	@Transactional
	@PostMapping("/categorie")
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        
        return serviceAdmin.addCategorie(categorie);
    }
	
	@Transactional
	@DeleteMapping("/categorie/{id}")
    public ResponseEntity<Map<String, String>> deleteCategorie(@PathVariable Long id) {
        
        return serviceAdmin.deleteCategorie(id);
    }
	
	@Transactional
	@PutMapping("/categorie/{id}")
    public ResponseEntity<Categorie> updateCategorie(@PathVariable Long id,@RequestBody Categorie categorie) {
        
        return serviceAdmin.updateCategorie(id,categorie);
    }

	
	
	
	// END MAP Pour les Produits
	@GetMapping("/produits")
    public ResponseEntity<List<Produit>> getAllProduits() {
        
        return serviceAdmin.getAllProduits();
    }
	
	
	@GetMapping("/produit/{id}")
    public ResponseEntity<Produit> getProduit(@PathVariable Long id) {
        
        return serviceAdmin.getProduit(id);
    }
	
	@Transactional
	@PostMapping("/produit")
    public ResponseEntity<Produit> addProduit(@RequestBody RequestAddProduit request) {
        
        return serviceAdmin.addProduit(request);
    }
	
	@Transactional
	@DeleteMapping("/produit/{id}")
    public ResponseEntity<Map<String, String>> deleteProduit(@PathVariable Long id) {
        
        return serviceAdmin.deleteProduit(id);
    }
	
	@Transactional
	@PutMapping("/produit/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id,@RequestBody RequestAddProduit request) {
        
        return serviceAdmin.updateProduit(id,request);
    }


}
