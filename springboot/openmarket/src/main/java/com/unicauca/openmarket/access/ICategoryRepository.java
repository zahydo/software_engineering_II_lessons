/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.unicauca.openmarket.access;

import com.unicauca.openmarket.domain.entity.Category;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author SANTIAGO
 */
public interface ICategoryRepository  extends CrudRepository<Category, Long>{
    
}
