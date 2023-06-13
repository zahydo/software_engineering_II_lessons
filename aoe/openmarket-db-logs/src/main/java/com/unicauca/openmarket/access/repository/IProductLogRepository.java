package com.unicauca.openmarket.access.repository;

import org.springframework.data.repository.CrudRepository;

import com.unicauca.openmarket.domain.entity.ProductLog;

public interface IProductLogRepository extends CrudRepository<ProductLog, Long> {

}
