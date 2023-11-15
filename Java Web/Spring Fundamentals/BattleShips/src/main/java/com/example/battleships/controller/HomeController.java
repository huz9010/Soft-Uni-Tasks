package com.example.battleships.controller;

import com.example.battleships.domain.model.binding.HomeBindingModel;
import com.example.battleships.domain.model.service.UserServiceModel;
import com.example.battleships.domain.model.view.ShipViewModel;
import com.example.battleships.service.ShipService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;

@Controller
public class HomeController {

    private final ShipService shipService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public HomeController(ShipService shipService, HttpSession httpSession, ModelMapper modelMapper) {
        this.shipService = shipService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        UserServiceModel currentUser = modelMapper.map(this.httpSession.getAttribute("user"), UserServiceModel.class);
        Collection<ShipViewModel> ships = this.shipService.getAllShips();

        model.addAttribute("currentUser", currentUser);
        model.addAttribute("allShips", ships);
        model.addAttribute("attackerShips",
                ships.stream().filter(s -> s.getUser().getId().equals(currentUser.getId())));
        model.addAttribute("defenderShips",
                ships.stream().filter(s -> !s.getUser().getId().equals(currentUser.getId())));

        return "/home";
    }

    @PostMapping("/home")
    public String battle(@Valid HomeBindingModel homeBindingModel, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute(
                            "homeBindingModel", homeBindingModel)
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.homeBindingModel", bindingResult);

            return "redirect:/home";
        }

        this.shipService.fight(homeBindingModel);
        return "redirect:/home";
    }

    @ModelAttribute
    public HomeBindingModel homeBindingModel() {
        return new HomeBindingModel();
    }
}
