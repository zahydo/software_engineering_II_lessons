package com.unicauca.openmarket.domain.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.repository.ICategoryRepository;
import com.unicauca.openmarket.domain.entity.Category;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    /**
     * Servicio para buscar todos las categorias
     * 
     * @return Listado de categorias
     */
    @Override
    @Transactional(readOnly = true)
    public List<Category> findAll(){
        return (List<Category>) repository.findAll();
    }

     /**
     * Buscar categorias por Id
     * 
     * @param id identificador categorias
     * @return objeto de tipo categorias
     */
    @Override
    public Category find(Long id) {
        Category cat= repository.findById(id).orElse(null);
        return cat;
    }

      /**
     * Crear un nuevo categorias
     * 
     * @param categoria a crear
     * @return categoria creado
     */
    @Override
    public Category create(Category category){
        return repository.save(category);
    }

    /**
     * modifica una categorias
     * 
     * @param id identificador de la  categoria a modificarr
     * @param product categoria con los datos a editar
     * @return categoria modifica
     */
    @Override
    @Transactional
    public Category update(Long id,Category category){
        Category cat = this.find(id);
        cat.setName(category.getName());
        return repository.save(cat);
    }

    /**
     * Eliminar una categoria
     * 
     * @param id identificador de la categoria a eliminar
     */
    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}