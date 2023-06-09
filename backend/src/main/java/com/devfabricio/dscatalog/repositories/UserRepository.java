package com.devfabricio.dscatalog.repositories;

import com.devfabricio.dscatalog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
