package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.repository.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{
    
    @Autowired
    private ICategoryRepository repository;
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll(){
        return (List<Category>) repository.findAll();
    }
    @Override
    public Category find(Long id){
        Category categ = repository.findById(id).orElse(null);
        return categ;
    }
    @Override
    @Transactional
    public Category create(Category category){
        return repository.save(category);
    }
    @Override
    @Transactional
    public Category update(Long id, Category category){
        Category categ = this.find(id);
        categ.setName(category.getName());
        return repository.save(categ);
    }
    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
}
