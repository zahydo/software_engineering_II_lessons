/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicauca.openmarket.access;

import co.edu.unicauca.openmarket.domain.Product;
import java.util.List;

/**
 *
 * @author agred
 */
public interface IProductRepository extends IRepository<Product>{
    List<Product> findByCategoryID(Long id);
    
}
