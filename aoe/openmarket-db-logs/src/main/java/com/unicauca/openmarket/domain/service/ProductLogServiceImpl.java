package com.unicauca.openmarket.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarket.access.repository.IProductLogRepository;
import com.unicauca.openmarket.domain.entity.ProductLog;

@Service // Para que sea un componente de Spring
public class ProductLogServiceImpl implements IProductLogService {
    @Autowired // Inyecta una dependencia
    private IProductLogRepository repository;

    /**
     * Busca todos los productos
     * 
     * @return Lista de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductLog> findAll() {
        return (List<ProductLog>) repository.findAll();
    }

    /**
     * Busca un producto por su id
     * 
     * @param id id del producto
     * @return producto
     */
    @Override
    @Transactional
    public ProductLog find(Long id) {
        ProductLog product = repository.findById(id).orElse(null);
        return product;
    }

    /**
     * Crea un producto
     * 
     * @param product producto a crear
     * @return producto creado
     */
    @Override
    @Transactional
    public ProductLog create(ProductLog product) {

        // Save the product
        ProductLog savedProduct = repository.save(product);
        // Send the event message
        return savedProduct;

    }

    /**
     * Actualiza un producto
     * 
     * @param id      id del producto
     * @param product producto a actualizar
     * @return producto actualizado
     */
    @Override
    @Transactional
    public ProductLog update(Long id, ProductLog product) {
        ProductLog productUpdate = this.find(id);
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        // Save the product
        ProductLog updateProduct = repository.save(productUpdate);
        // Send the event message
        return updateProduct;
    }

    /**
     * Elimina un producto
     * 
     * @param id id del producto
     */
    @Override
    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }
}
