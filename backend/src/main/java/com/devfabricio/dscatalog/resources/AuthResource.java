package com.devfabricio.dscatalog.resources;

import com.devfabricio.dscatalog.dtos.EmailDTO;
import com.devfabricio.dscatalog.dtos.UserDTO;
import com.devfabricio.dscatalog.dtos.UserInsertDTO;
import com.devfabricio.dscatalog.dtos.UserUpdateDTO;
import com.devfabricio.dscatalog.services.AuthService;
import com.devfabricio.dscatalog.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

    @Autowired
    private AuthService authService;

    @PostMapping(value = "/recover-token")
    public ResponseEntity<Void> createRoverToken(@Valid @RequestBody EmailDTO body) {
        authService.createRoverToken(body);
        return ResponseEntity.noContent().build();
    }
}
