package com.example.battleships.service.impl;

import com.example.battleships.domain.entity.Category;
import com.example.battleships.domain.entity.Ship;
import com.example.battleships.domain.entity.User;
import com.example.battleships.domain.model.binding.HomeBindingModel;
import com.example.battleships.domain.model.service.ShipServiceModel;
import com.example.battleships.domain.model.service.UserServiceModel;
import com.example.battleships.domain.model.view.ShipViewModel;
import com.example.battleships.repository.ShipRepository;
import com.example.battleships.service.CategoryService;
import com.example.battleships.service.ShipService;
import com.example.battleships.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShipServiceImpl implements ShipService {

    private final ModelMapper modelMapper;
    private final ShipRepository shipRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public ShipServiceImpl(ModelMapper modelMapper, ShipRepository shipRepository, UserService userService, CategoryService categoryService) {
        this.modelMapper = modelMapper;
        this.shipRepository = shipRepository;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public void addShip(ShipServiceModel ship, UserServiceModel user) {
        Ship shipEntity = this.modelMapper.map(ship, Ship.class);
        User currentUser = this.userService.findById(user.getId());
        Category categoryEntity = this.categoryService.findByCategory(ship.getCategory());

        shipEntity.setUser(currentUser);
        shipEntity.setCategory(categoryEntity);

        this.shipRepository.save(shipEntity);
    }

    @Override
    public boolean findByName(String shipName) {
        return this.shipRepository.findByName(shipName).isEmpty();
    }

    @Override
    public Collection<ShipViewModel> getAllShips() {
        return this.shipRepository.findAllByIdNotNullOrderByNameAscHealthAscPowerAsc().stream()
                .map(s -> {
                    ShipViewModel ship = this.modelMapper.map(s, ShipViewModel.class);
                    UserServiceModel user = this.modelMapper.map(s.getUser(), UserServiceModel.class);
                    ship.setUser(user);
                    return ship;
                })
                .collect(Collectors.toList());
    }

    @Override
    public void fight(HomeBindingModel shipIds) {

        Optional<Ship> attacker = this.shipRepository.findById(shipIds.getAttackerShipId());
        Optional<Ship> defender = this.shipRepository.findById(shipIds.getDefenderShipId());

        if (attacker.isEmpty() || defender.isEmpty()) {
            return;
        }

        Ship attackerShip = attacker.get();
        Ship defenderShip = defender.get();

        defenderShip.setHealth(defenderShip.getHealth() - attackerShip.getPower());

        if (defenderShip.getHealth() <= 0) {
            this.shipRepository.delete(defenderShip);
            return;
        }

        this.shipRepository.save(defenderShip);
    }
}


