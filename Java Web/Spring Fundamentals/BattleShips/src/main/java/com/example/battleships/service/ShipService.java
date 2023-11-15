package com.example.battleships.service;

import com.example.battleships.domain.model.binding.HomeBindingModel;
import com.example.battleships.domain.model.service.ShipServiceModel;
import com.example.battleships.domain.model.service.UserServiceModel;
import com.example.battleships.domain.model.view.ShipViewModel;

import java.util.Collection;

public interface ShipService {

    void addShip(ShipServiceModel ship, UserServiceModel user);

    boolean findByName(String shipName);

    Collection<ShipViewModel> getAllShips();

    void fight(HomeBindingModel homeBindingModel);
}
