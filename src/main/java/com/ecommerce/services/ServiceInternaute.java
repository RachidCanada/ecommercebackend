package com.ecommerce.services;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.entities.Categorie;
import com.ecommerce.entities.Client;
import com.ecommerce.entities.Compte;
import com.ecommerce.entities.Panier;
import com.ecommerce.entities.Produit;
import com.ecommerce.repositories.RepositoryCategorie;
import com.ecommerce.repositories.RepositoryClient;
import com.ecommerce.repositories.RepositoryCompte;
import com.ecommerce.repositories.RepositoryPanier;
import com.ecommerce.repositories.RepositoryProduit;
import com.ecommerce.requests.RequestConnect;
import com.ecommerce.requests.RequestRegister;
import com.ecommerce.utils.FonctionsUtiles;
import com.ecommerce.utils.TypeCompte;
import com.ecommerce.exceptions.EmailNonDisponibleException;

@Service
public class ServiceInternaute {
	
	@Autowired
	private RepositoryCategorie repositoryCategorie;

	@Autowired
	private RepositoryProduit repositoryProduit;
	
	@Autowired
	private RepositoryCompte repositoryCompte;

	@Autowired
	private RepositoryClient repositoryClient;
	
	@Autowired
	private RepositoryPanier repositoryPanier;
	
	@Autowired
	private FonctionsUtiles functions;
	
	@Autowired
	private ServiceMailing serviceMailing;
	

	public ResponseEntity< Map<Long, List<Produit>> > getAllProduitsByName(String nomProduit) {
		List<Categorie> categories = repositoryCategorie.findAll();
		List<Produit> produits = repositoryProduit.findByNomContaining(nomProduit);

		// Création d'une LinkedHashMap pour classer les produits produit par catégorie
		Map<Long, List<Produit>> produitsParCategorie = new LinkedHashMap<>();

		// Organisation des produits par catégorie
		for (Categorie categorie : categories) {
			// Filtrer les produits appartenant à la catégorie en cours
			List<Produit> produitsDansCategorie = produits.stream()
					.filter(produit -> produit.getCategorie().getId() == categorie.getId()).collect(Collectors.toList());

			// Ajouter la catégorie et ses produits triés dans la Map
			produitsParCategorie.put(categorie.getId(), produitsDansCategorie);
		}

		return ResponseEntity.status(HttpStatus.OK).body(produitsParCategorie);
	}

	public ResponseEntity< Client > registerClient(RequestRegister request){
		Compte compte = request.getCompte();
		Client client = request.getClient();
		
		// Vérification si l'émail a déjà été utilisé par un autre utilisateur
		if(isEmailused(compte.getEmail())) {
			throw new EmailNonDisponibleException("Email non disponible");
		}
		// Enregistrement du compte
		repositoryCompte.save(compte); 
		
		//Association du compte au client
		client.setCompte(compte);
		
		// Création d'un nouveau panier prêt à recevoir des produits du client
		Panier panier = new Panier();
		repositoryPanier.save(panier);
		
		// Initialiser une nouvelle liste
		List<Panier> paniers = new ArrayList<>();
		paniers.add(new Panier());

		// Associer la liste de paniers au client
		client.setPaniers(paniers);
		
		// Enregistrement du client
		repositoryClient.save(client);
		
		// Envoie de mail de confirmation
		serviceMailing.confirmationInscription(compte.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}

	public ResponseEntity<Compte> registerAdmin(Compte compte) {
		// TODO Auto-generated method stub
		// Vérification si l'émail a déjà été utilisé par un autre utilisateur
		if(isEmailused(compte.getEmail())) {
			throw new EmailNonDisponibleException("Email non disponible");
		}
		compte.setType(TypeCompte.ADMINISTRATEUR);
		// Enregistrement du compte
		repositoryCompte.save(compte); 
		
		// Envoie de mail de confirmation
		serviceMailing.confirmationInscription(compte.getEmail());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(compte);
	}
	
	public ResponseEntity<Map<String, String>> connect(RequestConnect request){
		String emailRequest = request.getCompte().getEmail();
		String passwordRequest = request.getCompte().getPassword();
		
		Compte compte = repositoryCompte.findCompteByEmail(emailRequest);
		
		// Vérification de l'existence du mail
		if (compte == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            						.body(functions.response_message("Compte inexistant"));
        }
		
		// Vérification du mot de passe
		if(!isPasswordCorrect(compte,passwordRequest)) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
									.body(functions.response_message("Mot de passe incorrect"));
		}
		
		// ASSOCIATION DU PANIER 
		Client client = compte.getClient();
		
		// 
		
		
		return ResponseEntity.status(HttpStatus.OK).body(functions.response_message("succes"));
	}
	
	
	public boolean isEmailused(String email) {
		if(repositoryCompte.findCompteByEmail(email)!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean isPasswordCorrect(Compte compte, String password) {
		String correctPassword = compte.getPassword();
		
		if(correctPassword.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	private void gestionPanier() {
		
	}
}
