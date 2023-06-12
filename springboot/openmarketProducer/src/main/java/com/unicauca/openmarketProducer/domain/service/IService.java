package com.unicauca.openmarketProducer.domain.service;

import java.io.Serializable;
import java.util.List;

public interface IService<T extends Serializable> {
    public List<T> findAll();

    public T find(Long id);

    public T create(T object);

    public T update(Long id, T object);

    public void delete(Long id);
}
