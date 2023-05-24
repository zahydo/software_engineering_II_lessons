package com.openmarket.opemarket.domain.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openmarket.opemarket.Acces.ICategoryRepository;
import com.openmarket.opemarket.domain.model.Category;

@Service
public class CategoryService implements ICategoryService{
    @Autowired // Injects an instance of IProductRepository into this service without the need of a constructor
    private ICategoryRepository repository;

    @Override
    @Transactional(readOnly = false)
    public Category save(Category object) {
        return this.repository.save(object);
    }

    @Override
    public boolean edit(Long id, Category object) {
         // TODO Auto-generated method stub
         Category editCategory = findById(id);
         object.setId(editCategory.getId());
         delete(id);
         Category editedCategory = save(object);
         if(editedCategory != null){
             return true;
         }else{
             return false;
         }
    }

    @Override
    @Transactional(readOnly = false)
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Category findById(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public List<Category> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) this.repository.findAll();
    }
    
}
