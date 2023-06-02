package com.devfabricio.dscatalog.services;

import com.devfabricio.dscatalog.dtos.CategoryDTO;
import com.devfabricio.dscatalog.entities.Category;
import com.devfabricio.dscatalog.repositories.CategoryRepository;
import com.devfabricio.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = categoryRepository.findAll();
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category obj = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Entity Not Found"));
        return new CategoryDTO(obj);
    }
}
