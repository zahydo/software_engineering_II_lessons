package co.unicauca.open_market.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.unicauca.open_market.access.dao.ICategoryRepository;
import co.unicauca.open_market.domain.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository repository;

    @Override
    @Transactional(readOnly=true)
    public List<Category> findAll() {
        return (List<Category>) this.repository.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Category find(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly=false)
    public Category create(Category category) {
        return this.repository.save(category);
    }

    @Override
    @Transactional(readOnly=false)
    public Category update(Long id, Category category) {
        Category updateCategory = find(id);
        updateCategory.setName(category.getName());
        return this.repository.save(category);
    }

    @Override
    @Transactional(readOnly=false)
    public Category delete(Long id) {
        Category deleteCategory = find(id);
        this.repository.delete(deleteCategory);
        return deleteCategory;
    }
    
}
