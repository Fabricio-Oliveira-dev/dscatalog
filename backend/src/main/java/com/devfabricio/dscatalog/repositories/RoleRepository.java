package com.devfabricio.dscatalog.repositories;

import com.devfabricio.dscatalog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
