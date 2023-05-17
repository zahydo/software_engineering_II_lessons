/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Product;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ahurtado
 */
public class LoadDataRepositoryDecorator implements IProductRepository{
    IProductRepository repository;
    
    @Override
    public boolean save(Product newProduct) {
        return repository.save(newProduct);
    }

    @Override
    public boolean edit(Long id, Product product) {
        return repository.edit(id, product);
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }

    @Override
    public Product findById(Long id){
        return repository.findById(id);
    }
    
    @Override
    public List<Product>  findByName(String name){
        return repository.findByName(name);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }
    
    public boolean loadProducts(File file){
        List<Product> products = new ArrayList<>(); 
        //abrir archivo
        //leer productos y guardarlos en una lista de productos
        for (Product each: products){
            repository.save(each);
        }
        return true;
    }
    
}
