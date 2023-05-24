package com.openmarket.opemarket.domain.Service;


import java.util.List;


public interface IRepository<T> {

    T save(T object);

    boolean edit(Long id, T object);

    void delete(Long id);

    T findById(Long id);

    List<T> findByName(String name);

    List<T> findAll();
    
}
