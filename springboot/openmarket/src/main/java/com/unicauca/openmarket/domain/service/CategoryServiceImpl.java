package com.unicauca.openmarket.domain.service;
import com.unicauca.openmarket.access.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;
    @Override
    @Transactional
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    @Override
    public Category find(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        Category cat = this.find(id);
        cat.setName(category.getName());
        return repository.save(cat);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
