package com.unicauca.app.domain.services;

import com.unicauca.app.access.IUserRepository;
import com.unicauca.app.domain.model.User;

public class UserServiceImpl implements IUserService{
    private IUserRepository userRepository;

    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            userRepository.delete(user);
        }
    }
}