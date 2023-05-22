/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unicauca.openmarket.access;

import java.util.List;

/**
 *
 * @author Joe de la Poer
 */
public interface IRepository<T> {
  boolean save(T object);
  boolean edit(Long id, T object);

  boolean delete(Long id);

  T findById(Long id);

  List<T> findByName(String name);

  List<T> findAll();
}
