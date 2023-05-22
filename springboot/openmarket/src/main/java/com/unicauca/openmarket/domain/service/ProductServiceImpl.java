/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unicauca.openmarket.domain.service;

import com.unicauca.openmarket.access.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author SANTIAGO
 */

@Service //Para que sea un componente de spring

public class ProductServiceImpl implements IProductService{

    @Autowired
    IProductRepository repository; 
    
    /**
     * Servicio para encontrar todos los productos
     * @return Listado en productos. 
     */
    @Transactional(readOnly =  true)
    @Override
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    /**
     * Servicio para encontrar un producto con su id
     * @param  id identificador del producto. 
     * @return Objeto de tipo producto.  
     */
    @Override
    public Product find(long id) {
        Product prod = repository.findById(id).orElse(null);
        return prod;
    }

    /**
     * Servicio para crear un producto.
     * @param  product producto que se va a crear en la bd. 
     * @return Objeto de tipo producto.  
     */
    @Override
    public Product create(Product product) {
        return repository.save(product);
    }

     /**
     * Servicio para editar un producto. 
     * @param  id El id del producto a actualizar. 
     * @param  product producto que contiene los datos editados en la bd. 
     * @return Objeto de tipo producto.  
     */
    @Override
    public Product update(long id, Product product) {
        Product prod = this.find(id);
        prod.setName(product.getName());
        prod.setDescription(product.getDescription());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }

    /**
     * Servicio para eliminar un producto por id. 
     * @param id el id del producto a eliminar. 
     */
    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
    
}
