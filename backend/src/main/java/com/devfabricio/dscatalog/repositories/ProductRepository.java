package com.devfabricio.dscatalog.repositories;

import com.devfabricio.dscatalog.entities.Category;
import com.devfabricio.dscatalog.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
