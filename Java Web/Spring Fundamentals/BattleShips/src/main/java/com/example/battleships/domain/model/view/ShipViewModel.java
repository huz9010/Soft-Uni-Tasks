package com.example.battleships.domain.model.view;

import com.example.battleships.domain.model.service.UserServiceModel;

public class ShipViewModel {

    private Long id;
    private String name;
    private Long health;
    private Long power;
    private UserServiceModel user;

    public ShipViewModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getHealth() {
        return health;
    }

    public void setHealth(Long health) {
        this.health = health;
    }

    public Long getPower() {
        return power;
    }

    public void setPower(Long power) {
        this.power = power;
    }

    public UserServiceModel getUser() {
        return user;
    }

    public void setUser(UserServiceModel user) {
        this.user = user;
    }
}
