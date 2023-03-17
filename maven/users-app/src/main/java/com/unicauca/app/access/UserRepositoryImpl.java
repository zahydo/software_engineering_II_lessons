package com.unicauca.app.access;

import com.unicauca.app.domain.model.User;

public class UserRepositoryImpl implements IUserRepository {

  @Override
  public void save(User user) {
    System.out.println("Guardando los datos del usuario en MySQL");
  }

  @Override
  public void delete(User user) {
    System.out.println("Eliminando datos del usuario en MySQL");
  }

  @Override
  public User findByUsername(String username) {
    System.out.println("buscando el username en MySQL");
    return null;
  }
}
