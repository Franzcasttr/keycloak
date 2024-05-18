package com.food.keycloak.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    List<ProductEntity> findAll(Sort sort);

    @Query("SELECT p FROM ProductEntity p WHERE LOWER(p.name) LIKE LOWER(:name) AND p.category = :category")
     Page<ProductEntity> findByNameContainingIgnoreCaseAndCategory(String name, String category, Pageable pageable);
}
