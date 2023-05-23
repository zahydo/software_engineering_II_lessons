
package com.unicauca.openmarket.service;

import com.unicauca.openmarket.access.dao.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author brayan
 */

@Service//para que sea un servcio de spring
public class ProductServiceImpl implements IProductService{

    
    @Autowired//para que se inyecte el repositorio
    private IProductRepository repository;
    /**
     * servicio para buscar todos los productos
     * @return listado de productos
     */
    @Override
    @Transactional(readOnly=true)//para que este sincronizada con la base de datos
    public List<Product> findAll() {
       return (List<Product>)repository.findAll();
    }
    /**
     * servicio para buscar un producto por su id
     * @param Id identificador 
     * @return objeto del tipo producto
     */
    @Override
    @Transactional
    public Product find(Long Id) {
        Product prod=repository.findById(Id).orElse(null);
        return prod;
    }
    /**
     * servicio para crea un nuevo producto
     * @param product producto a crer en la bd
     * @return producto creado
     */
    @Override
    @Transactional
    public Product create(Product product) {
        return repository.save(product);
    }
    /**
     * servicio para editar un producto
     * @param id ide del producto
     * @param product datos del producto
     * @return objeto tipo producto
     */
    
    @Override
    @Transactional
    public Product update(Long id, Product product) {
       Product prod=this.find(id);
       prod.setName(product.getName());
        prod.setDescription(product.getDescription());
       prod.setPrice(product.getPrice());
       return repository.save(prod);
    }
    /**
     * Servivio para elimiunar un producto por id
     * @param id el id del producto a eliminar
     */
    @Override
    @Transactional
    public void delete(Long id) {
      repository.deleteById(id);
    }
    
}
