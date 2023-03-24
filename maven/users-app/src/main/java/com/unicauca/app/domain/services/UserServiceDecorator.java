package com.unicauca.app.domain.services;

public abstract class UserServiceDecorator implements IUserService {
    protected IUserService userService;

    UserServiceDecorator(IUserService userService) {
        this.userService = userService;
    }
}
