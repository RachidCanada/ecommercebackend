package com.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.entities.ProduitPanier;

public interface RepositoryProduitPanier extends JpaRepository<ProduitPanier, Long>{

}
