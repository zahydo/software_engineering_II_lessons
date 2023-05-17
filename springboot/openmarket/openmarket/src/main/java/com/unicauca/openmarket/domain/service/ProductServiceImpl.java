package com.unicauca.openmarket.domain.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.dao.IProductRepository;
import com.unicauca.openmarket.domain.entity.Product;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepository repository;

    /**
     * Servicio para buscar todos los productos 
     * @return Listado de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    /**
     * Busca un producto por su Id
     * @param productId identificador del producto
     * @return Objeto de tipo producto
     */
    @Override
    public Product find(Long productId) {
        Product prod = repository.findById(productId).orElse(null);
        return prod;
    }

    /**
     * Crea un nuevo producto
     * @param product producto a crear en la base de datos
     * @return Producto creado
     */
    @Override
    @Transactional
    public Product create(Product product) {
        return repository.save(product);
    }

    /**
     * Modifica o edita un producto
     * @param productId identificador del producto a modificar
     * @param product producto con los datos a editar
     * @return Listado de productos
     */
    @Override
    @Transactional
    public Product update(Long productId, Product product) {
        Product prod = this.find(productId);
        prod.setName(product.getName());
        prod.setPrice(product.getPrice());
        return repository.save(prod);
    }

    @Override
    @Transactional
    public void delete(Long productId) {
        repository.deleteById(productId);
    }

}
