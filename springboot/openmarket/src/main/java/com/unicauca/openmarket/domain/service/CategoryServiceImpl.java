package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openmarket.access.repository.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;

@Service // Indicates this class is a service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired // Injects an instance of ICategoryRepository into this service without the need
               // of a constructor
    private ICategoryRepository repository;

    @Override
    @Transactional(readOnly = true) // Para que esté sincronizada con la bd

    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Category find(Long id) {
        Category categ = repository.findById(id).orElse(null);
        return categ;
    }

    @Override
    @Transactional
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    @Transactional
    public Category update(Long id, Category category) {
        Category categ = this.find(id);
        categ.setName(category.getName());
        return repository.save(categ);
    }

    @Override
    @Transactional
    public void delete(long id) {
        repository.deleteById(id);
    }

}
