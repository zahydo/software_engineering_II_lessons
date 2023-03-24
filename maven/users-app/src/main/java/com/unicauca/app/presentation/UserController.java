package com.unicauca.app.presentation;

import com.unicauca.app.domain.model.User;
import com.unicauca.app.domain.services.IUserService;

public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    public void createUser(String username, String password) {
        User user = new User(username, password);
        userService.createUser(user);
    }

    public void deleteUser(String username) {
        userService.deleteUser(username);
    }

    public void authenticate(String username, String password) {
        userService.getJWT(username, password);
    }
}