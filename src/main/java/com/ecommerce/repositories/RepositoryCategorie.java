package com.ecommerce.repositories;

import com.ecommerce.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryCategorie extends JpaRepository<Categorie, Long> {
}
