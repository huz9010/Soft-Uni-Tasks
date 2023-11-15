package com.example.battleships.service;

import com.example.battleships.domain.entity.User;
import com.example.battleships.domain.model.binding.UserRegisterBindingModel;
import com.example.battleships.domain.model.service.UserServiceModel;

public interface UserService {

    boolean findByEmail(String email);

    boolean findByUsername(String username);

    UserServiceModel register(UserServiceModel user);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(Long id);
}
