package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.dao.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService{

    @Autowired
    private ICategoryRepository repository;

    /**
     * Servicio para buscar todos los categorias 
     * @return Listado de categorias
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return (List<Category>) repository.findAll();
    }

    /**
     * Busca un categoria por su Id
     * @param CategoryId identificador del categoria
     * @return Objeto de tipo categoria
     */
    @Override
    public Category find(Long CategoryId) {
        Category prod = repository.findById(CategoryId).orElse(null);
        return prod;
    }

    /**
     * Crea un nuevo categoria
     * @param Category categoria a crear en la base de datos
     * @return Producto creado
     */
    @Override
    @Transactional
    public Category create(Category Category) {
        return repository.save(Category);
    }

    /**
     * Modifica o edita un categoria
     * @param CategoryId identificador del categoria a modificar
     * @param Category Categoria con los datos a editar
     * @return Listado de Categorias
     */
    @Override
    @Transactional
    public Category update(Long CategoryId, Category Category) {
        Category prod = this.find(CategoryId);
        prod.setName(Category.getName());
        return repository.save(prod);
    }

    @Override
    @Transactional
    public void delete(Long CategoryId) {
        repository.deleteById(CategoryId);
    }

}