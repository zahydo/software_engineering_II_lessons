package com.openmarket.opemarket.domain.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.openmarket.opemarket.Acces.IProductRepository;
import com.openmarket.opemarket.domain.Service.IProductService;
import com.openmarket.opemarket.domain.model.Product;


@Service
public class ProductService implements IProductService{

    @Autowired // Injects an instance of IProductRepository into this service without the need of a constructor
    private IProductRepository repository;



    
    @Transactional(readOnly = false)
    public Product save(Product product) {
        return this.repository.save(product);
    }

   
    public boolean edit(Long id, Product object) {
        // TODO Auto-generated method stub
        Product editProduct = findById(id);
        object.setId(editProduct.getId());
        delete(id);
        Product editedProduct = save(object);
        if(editedProduct != null){
            return true;
        }else{
            return false;
        }
    }

    
    @Transactional(readOnly = false)
    public void delete(Long id) {
        this.repository.deleteById(id);
    }

    
    @Transactional(readOnly = true)
    public Product findById(Long id) {
        return this.repository.findById(id).orElse(null);
        
    }

  
    public List<Product> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

    
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return (List<Product>)this.repository.findAll();
    }


    
}
