package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.User;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean findByEmail(String email) {
        return this.userRepository.findByEmail(email).isEmpty();
    }

    @Override
    public Long getLoggedUserId(String username) {
        return this.userRepository.findByUsername(username).get().getId();
    }

    @Override
    public boolean findByUsername(String username) {
        return this.userRepository.findByUsername(username).isEmpty();
    }

    @Override
    public UserServiceModel register(UserServiceModel user) {
        return this.modelMapper.map(
                this.userRepository.save(
                        this.modelMapper.map(user, User.class)), UserServiceModel.class
                );
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {
        return this.userRepository.findByUsernameAndPassword(username, password)
                .map(user -> this.modelMapper.map(user, UserServiceModel.class))
                .orElse(null);
    }

    @Override
    public User findById(Long id) {
        return this.userRepository.findById(id).get();
    }
}
