package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.service.UserServiceModel;

public interface UserService {
    boolean findByEmail(String email);

    Long getLoggedUserId(String username);

    boolean findByUsername(String username);

    UserServiceModel register(UserServiceModel user);

    UserServiceModel findByUsernameAndPassword(String username, String password);

    User findById(Long id);
}
