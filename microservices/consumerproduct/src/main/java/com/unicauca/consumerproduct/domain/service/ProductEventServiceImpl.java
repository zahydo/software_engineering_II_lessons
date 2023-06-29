package com.unicauca.consumerproduct.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.unicauca.consumerproduct.access.repository.IProductEventRepository;
import com.unicauca.consumerproduct.domain.entity.ProductEvent;

@Service // Para que sea un componente de Spring
public class ProductEventServiceImpl implements IProductEventService {
    @Autowired // Inyecta una dependencia
    private IProductEventRepository repository;

    /**
     * Busca todos los evento de productos
     * 
     * @return Lista de evento de productos
     */
    @Override
    @Transactional(readOnly = true)
    public List<ProductEvent> findAll() {
        return (List<ProductEvent>) repository.findAll();
    }

    /**
     * Busca un evento de producto por su id
     * 
     * @param id id del evento de producto
     * @return evento de producto
     */
    @Override
    @Transactional
    public ProductEvent find(Long id) {
        ProductEvent product = repository.findById(id).orElse(null);
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
    public ProductEvent create(ProductEvent product) {

        // Save the product
        ProductEvent savedProduct = repository.save(product);
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
    public ProductEvent update(Long id, ProductEvent product) {
        ProductEvent productUpdate = this.find(id);
        productUpdate.setName(product.getName());
        productUpdate.setPrice(product.getPrice());
        // Save the product
        ProductEvent updateProduct = repository.save(productUpdate);
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
