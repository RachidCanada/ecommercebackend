package com.ecommerce.repositories;

import com.ecommerce.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RepositoryProduit extends JpaRepository<Produit, Long> {
    List<Produit> findByNomContaining(String keyword);
}
