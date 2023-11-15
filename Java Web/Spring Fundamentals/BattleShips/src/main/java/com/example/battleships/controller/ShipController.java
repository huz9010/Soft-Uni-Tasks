package com.example.battleships.controller;

import com.example.battleships.domain.model.binding.ShipCreateBindingModel;
import com.example.battleships.domain.model.service.ShipServiceModel;
import com.example.battleships.domain.model.service.UserServiceModel;
import com.example.battleships.service.ShipService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ships")
public class ShipController {

    private final ShipService shipService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public ShipController(ShipService shipService, HttpSession httpSession, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public ShipCreateBindingModel shipCreateBindingModel() {
        return new ShipCreateBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "ship-add";
    }

    @PostMapping("/add")
    public String add(@Valid ShipCreateBindingModel shipCreateBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("shipCreateBindingModel", shipCreateBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.shipCreateBindingModel", bindingResult);

            return "redirect:/ships/add";
        }

        ShipServiceModel ship = this.modelMapper.map(shipCreateBindingModel, ShipServiceModel.class);
        UserServiceModel user = this.modelMapper.map(this.httpSession.getAttribute("user"), UserServiceModel.class);

        this.shipService.addShip(ship, user);

        return "redirect:/home";
    }
}

