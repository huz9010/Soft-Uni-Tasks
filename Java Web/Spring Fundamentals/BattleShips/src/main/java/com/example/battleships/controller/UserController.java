package com.example.battleships.controller;

import com.example.battleships.domain.model.binding.UserLoginBindingModel;
import com.example.battleships.domain.model.binding.UserRegisterBindingModel;
import com.example.battleships.domain.model.service.UserServiceModel;
import com.example.battleships.service.UserService;
import com.example.battleships.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public UserController(UserServiceImpl userService, HttpSession httpSession, ModelMapper modelMapper) {
        this.userService = userService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @ModelAttribute
    public UserLoginBindingModel userLoginBindingModel()  {
        return new UserLoginBindingModel();
    }

    @GetMapping("/register")
    public String register() {
        if (this.httpSession.getAttribute("user" ) != null) {
            return "redirect:/home";
        }
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterBindingModel userRegisterBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel)
                    .addFlashAttribute(
                    "org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);

            if (!userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {
                bindingResult.addError(new FieldError("passwordsMismatch", "confirmPassword", "Passwords mismatch"));
            }

            return "redirect:/users/register";
        }

        UserServiceModel user = this.modelMapper.map(userRegisterBindingModel, UserServiceModel.class);

        this.userService.register(user);
        return "redirect:/users/login";
    }

    @GetMapping("/login")
    public String login() {
        if (this.httpSession.getAttribute("user") != null) {
            return "redirect:/users/login";
        }
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginBindingModel userLoginBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute(
                    "org.springframework.validation.BindingResult.registrationDTO", bindingResult);

            return "redirect:/users/login";
        }

        UserServiceModel user = this.userService.findByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes
                    .addFlashAttribute("userLoginBindingModel", userLoginBindingModel)
                    .addFlashAttribute("badCredentials", true);

            return "redirect:/users/login";
        }

        this.httpSession.setAttribute("user", user);
        return "redirect:/home";
    }

    @GetMapping("/logout")
    public String logout() {
        this.httpSession.invalidate();
        return "redirect:/";
    }
}
