package com.devfabricio.dscatalog.repositories;

import com.devfabricio.dscatalog.entities.PasswordRecover;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRecoverRepository extends JpaRepository<PasswordRecover, Long> {

}
