package com.devfabricio.dscatalog.repositories;

import com.devfabricio.dscatalog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
