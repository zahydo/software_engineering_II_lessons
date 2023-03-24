package com.unicauca.app.domain.services;

import com.unicauca.app.domain.model.User;

public interface IUserService {
    public void createUser(User user);
    public void deleteUser(String username);
    public String getJWT(String username, String password);
}
