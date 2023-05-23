package com.unicauca.openmarket.domain.service;

import javax.print.attribute.standard.MediaSize.Other;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.repository.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductRepository repository;

    /**
     * Servicio para buscar todos los productos
     * 
     * @return Listado de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll(){
        return (List<Product>) repository.findAll();
    }

     /**
     * Buscar productos por Id
     * 
     * @param id identificador producto
     * @return objeto de tipo producto
     */
    @Override
    public Product find(Long id) {
        Product prod= repository.findById(id).orElse(null);
        return prod;
    }

      /**
     * Crear un nuevo producto
     * 
     * @param producto a crear
     * @return producto creado
     */
    @Override
    public Product create(Product product){
        return repository.save(product);
    }

    /**
     * modifica un producto
     * 
     * @param id identificador del producto a modificarr
     * @param product producto con los datos a editar
     * @return producto modifica
     */
    @Override
    @Transactional
    public Product update(Long id,Product product){
        Product prod = this.find(id);
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }

    /**
     * Eliminarun producto
     * 
     * @param id identificador del producto a eliminar
     */
    @Override
    @Transactional
    public void delete(Long id){
        repository.deleteById(id);
    }
    
}
