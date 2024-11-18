package com.ecommerce.entities;

import java.io.Serializable;

import com.ecommerce.utils.TypeAdresse;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Adresse implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private TypeAdresse typeAdresse;
	private String adresse;
	private String ville;
	private String province;
	private String pays;
	private String codePostal;
	
	@ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id")
	@JsonIgnoreProperties("Client-Adresse")
    private Client client;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TypeAdresse getTypeAdresse() {
		return typeAdresse;
	}

	public void setTypeAdresse(TypeAdresse typeAdresse) {
		this.typeAdresse = typeAdresse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Adresse(Long id, TypeAdresse typeAdresse, String adresse, String ville, String province, String pays,
			String codePostal, Client client) {
		super();
		this.id = id;
		this.typeAdresse = typeAdresse;
		this.adresse = adresse;
		this.ville = ville;
		this.province = province;
		this.pays = pays;
		this.codePostal = codePostal;
		this.client = client;
	}

	public Adresse() {
		super();
	}
	
	

}
