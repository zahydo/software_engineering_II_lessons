package com.unicauca.openmarketConsumer.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketConsumer.access.repository.ICategoryRepository;
import com.unicauca.openmarketConsumer.domain.entity.Category;

@Service // Para que sea un componente de Spring
public class CategoryServiceImpl implements ICategoryService {
    @Autowired // Inyecta una dependencia
    private ICategoryRepository repository;

    /**
     * Busca todas las categorias
     * 
     * @return Lista de categorias
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    /**
     * Busca una categoria por su id
     * 
     * @param id id de la categoria
     * @return categoria
     */
    @Override
    @Transactional
    public Category find(Long id) {
        Category category = repository.findById(id).orElse(null);
        return category;
    }

    /**
     * Crea una categoria
     * 
     * @param category categoria a crear
     * @return categoria creada
     */
    @Override
    @Transactional
    public Category create(Category category) {
        return repository.save(category);
    }

    /**
     * Actualiza una categoria
     * 
     * @param id       id de la categoria
     * @param category categoria a actualizar
     * @return categoria actualizada
     */
    @Override
    @Transactional
    public Category update(Long id, Category category) {
        Category categoryUpdate = this.find(id);
        categoryUpdate.setName(category.getName());
        return repository.save(categoryUpdate);
    }

    /**
     * Elimina una categoria
     * 
     * @param id id de la categoria
     */
    @Override
    @Transactional
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
