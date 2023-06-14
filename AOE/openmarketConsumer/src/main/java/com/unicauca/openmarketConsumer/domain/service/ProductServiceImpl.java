
package com.unicauca.openmarketConsumer.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.openmarketConsumer.access.dao.IProductRepository;
import com.unicauca.openmarketConsumer.domain.entity.Product;

@Service // Para que sea un componente de Spring
public class ProductServiceImpl implements IProductEventService {
    @Autowired // Inyecta una dependencia
    private IProductRepository repository;

    /**
     * Busca todos los evento de productos
     * 
     * @return Lista de evento de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>) repository.findAll();
    }

    /**
     * Busca un evento de producto por su id
     * 
     * @param id id del evento de producto
     * @return evento de producto
     */
    @Override
    @Transactional
    public Product find(Long id) {
        Product product = repository.findById(id).orElse(null);
        return product;
    }

    /**
     * Crea un evento de producto
     * 
     * @param product evento de producto a crear
     * @return evento de producto creado
     */
    @Override
    @Transactional
    public Product create(Product product) {

        // Save the product
        Product savedProduct = repository.save(product);
        // Send the event message
        return savedProduct;

    }

    /**
     * Actualiza un evento de producto
     * 
     * @param id      id del evento de producto
     * @param product evento de producto a actualizar
     * @return evento de producto actualizado
     */
    @Override
    @Transactional
    public Product update(Long id, Product product) {
        Product productUpdate = this.find(id);
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        // Save the product
        Product updateProduct = repository.save(productUpdate);
        // Send the event message
        return updateProduct;
    }

    /**
     * Elimina un evento de producto
     * 
     * @param id id del evento de producto
     */
    @Override
    @Transactional
    public void delete(Long id) {

        repository.deleteById(id);
    }
}
