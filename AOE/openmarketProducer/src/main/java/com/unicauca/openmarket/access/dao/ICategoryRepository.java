/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unicauca.openmarket.access.dao;

import com.unicauca.openmarket.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author brayan
 */
public interface ICategoryRepository extends CrudRepository<Category,Long> {
    
}
