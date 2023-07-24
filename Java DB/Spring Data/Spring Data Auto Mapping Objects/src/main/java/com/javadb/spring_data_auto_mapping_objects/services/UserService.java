package com.javadb.spring_data_auto_mapping_objects.services;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserLoginDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserRegisterDto;

public interface UserService {
    void registerUser(UserRegisterDto userRegisterDto);

    void loginUser(UserLoginDto userLoginDto);

    void logout();

    boolean isAdminLoggedIn();
}
