package com.unicauca.openMarket.domain.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unicauca.openMarket.access.ICategoryRepository;
import com.unicauca.openMarket.domain.entity.Category;

/**
 * @author nimbachi
 */

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository repository;

    /**
     * @brief Servivio para encontrar todas las categorias
     * @return Listado de categorias
     */
    @Override
    @Transactional
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    /**
     * @brief  Busca una categoria por su Id
     * @param id Identificador de la categoria
     * @return categoria encontrada de tipo Category
     */
    @Override
    public Category find(Long id) {
        Category cat = repository.findById(id).orElse(null);
        return cat;
    }

    /**
     * @brief Crea una nueva categoria
     * @return Nueva categoria creada
     */
    @Override
    public Category create(Category category) {
        return repository.save(category);
    }

    /**
     * @brief Edita una categria existente
     * @param id Identificador de la categoria a modificar
     * @param category Categoria que contiene los nuevos datos 
     * @return Categoria modificada
     */
    @Override
    public Category update(Long id, Category category) {
        Category cat = this.find(id);
        cat.setName(category.getName());
        return repository.save(cat);
    }

    /**
     * @brief Elimina el producto 
     * @param id Identificador de la categoria a eliminar
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
