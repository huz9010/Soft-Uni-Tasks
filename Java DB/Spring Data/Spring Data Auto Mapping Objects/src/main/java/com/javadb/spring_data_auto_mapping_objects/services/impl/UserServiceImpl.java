package com.javadb.spring_data_auto_mapping_objects.services.impl;

import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserLoginDto;
import com.javadb.spring_data_auto_mapping_objects.models.dtos.UserRegisterDto;
import com.javadb.spring_data_auto_mapping_objects.models.entities.User;
import com.javadb.spring_data_auto_mapping_objects.repositories.UserRepository;
import com.javadb.spring_data_auto_mapping_objects.services.UserService;
import com.javadb.spring_data_auto_mapping_objects.utils.ValidationUtil;
import jakarta.validation.ConstraintViolation;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Set;

import static com.javadb.spring_data_auto_mapping_objects.constants.ErrorMessages.*;
import static com.javadb.spring_data_auto_mapping_objects.constants.Messages.*;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    private User loggedInUser;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public void registerUser(UserRegisterDto userRegisterDto) {
        if (!userRegisterDto.getPassword().equals(userRegisterDto.getConfirmPassword())) {
            System.out.println("Password mismatch");
            return;
        }

        if (userRepository.findFirstByEmail(userRegisterDto.getEmail()).isPresent()) {
            System.out.println(EMAIL_EXISTS);
        }

        Set<ConstraintViolation<UserRegisterDto>> violations = validationUtil.violation(userRegisterDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = modelMapper.map(userRegisterDto, User.class);

        if (userRepository.count() == 0) {
            user.setAdmin(true);
        }
        userRepository.save(user);
        System.out.printf(USER_REGISTERED, user.getFullName());
    }

    @Override
    public void loginUser(UserLoginDto userLoginDto) {

        Set<ConstraintViolation<UserLoginDto>> violations = validationUtil.violation(userLoginDto);

        if (!violations.isEmpty()) {
            violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .forEach(System.out::println);
            return;
        }

        User user = userRepository.findFirstByEmailAndPassword(userLoginDto.getEmail(), userLoginDto.getPassword()).orElse(null);

        if (user == null) {
            System.out.println(INCORRECT_USER_OR_PASS);
            return;
        }

        loggedInUser = user;
        System.out.printf(USER_LOGGED_IN, loggedInUser.getFullName());
    }

    @Override
    public void logout() {
        if (loggedInUser == null) {
            System.out.println(NO_LOGGED_IN_USER);
            return;
        }

        System.out.printf(USER_LOGGED_OUT, loggedInUser.getFullName());
        loggedInUser = null;
    }

    public boolean isAdminLoggedIn() {
        return loggedInUser != null && loggedInUser.isAdmin();
    }
}

