package com.devfabricio.dscatalog.services;

import com.devfabricio.dscatalog.dtos.CategoryDTO;
import com.devfabricio.dscatalog.entities.Category;
import com.devfabricio.dscatalog.repositories.CategoryRepository;
import com.devfabricio.dscatalog.services.exceptions.DatabaseException;
import com.devfabricio.dscatalog.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public Page<CategoryDTO> findAllPaged(PageRequest pageRequest) {
        Page<Category> list = categoryRepository.findAll(pageRequest);
        return list.map(x -> new CategoryDTO(x));
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Category obj = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Entity Not Found"));
        return new CategoryDTO(obj);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO dto) {
        Category entity = new Category();
        entity.setName(dto.getName());
        entity = categoryRepository.save(entity);
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO update(Long id, CategoryDTO dto) {
        try {
            Category entity = categoryRepository.getReferenceById(id);
            entity.setName(dto.getName());
            entity = categoryRepository.save(entity);
            return new CategoryDTO(entity);
        }
        catch (EntityNotFoundException e) {
            throw  new ResourceNotFoundException("Id Not Found");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource Not found");
        }
        try {
            categoryRepository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
