package com.unicauca.openmarketConsumer.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketConsumer.access.repository.IActionProductsRepository;
import com.unicauca.openmarketConsumer.domain.entity.ActionProducts;

@Service
public class ActionProductsServiceImpl implements IActionProductsService{
    @Autowired
    private IActionProductsRepository repository;

    /**
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<ActionProducts> findAll() {
        return (List<ActionProducts>) repository.findAll();
    }

    /**
     * Busca un producto por su id
     * 
     * @param id id del producto
     * @return producto
     */
    @Override
    @Transactional
    public ActionProducts find(Long id) {
        ActionProducts actProduct = repository.findById(id).orElse(null);
        return actProduct;
    }

    /**
     * Crea un producto
     * 
     * @param product producto a crear
     * @return producto creado
     */
    @Override
    public ActionProducts create(ActionProducts actProduct) {
        return repository.save(actProduct);
    }

    /**
     * Actualiza un producto
     * 
     * @param id      id del producto
     * @param product producto a actualizar
     * @return producto actualizado
     */
    @Override
    public ActionProducts update(Long id, ActionProducts actProduct) {
        ActionProducts actProductUpdate = this.find(id);
        actProductUpdate.setName(actProduct.getName());
        actProductUpdate.setPrice(actProduct.getPrice());
        return repository.save(actProductUpdate) ;
    }

    /**
     * Elimina un producto
     * 
     * @param id id del producto
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
    
}
