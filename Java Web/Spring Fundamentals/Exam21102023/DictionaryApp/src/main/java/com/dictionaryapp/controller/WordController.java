package com.dictionaryapp.controller;

import com.dictionaryapp.model.binding.WordCreateBindingModel;
import com.dictionaryapp.model.service.UserServiceModel;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.service.UserService;
import com.dictionaryapp.service.WordService;
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
@RequestMapping("/words")
public class WordController {

    private final UserService userService;
    private final WordService wordService;
    private final HttpSession httpSession;
    private final ModelMapper modelMapper;

    public WordController(UserService userService, WordService wordService, HttpSession httpSession, ModelMapper modelMapper) {
        this.userService = userService;
        this.wordService = wordService;
        this.httpSession = httpSession;
        this.modelMapper = modelMapper;
    }

    @ModelAttribute
    public WordCreateBindingModel wordCreateBindingModel() {
        return new WordCreateBindingModel();
    }

    @GetMapping("/add")
    public String add() {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }
        return "word-add";
    }

    @PostMapping("/add")
    public String add(@Valid WordCreateBindingModel wordCreateBindingModel,
                        BindingResult bindingResult,
                        RedirectAttributes redirectAttributes) {

        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/users/login";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("wordCreateBindingModel", wordCreateBindingModel)
                    .addFlashAttribute("org.springframework.validation.BindingResult.wordCreateBindingModel", bindingResult);

            return "redirect:/words/add";
        }

        WordServiceModel word = this.modelMapper.map(wordCreateBindingModel, WordServiceModel.class);
        UserServiceModel user = this.modelMapper.map(this.httpSession.getAttribute("user"), UserServiceModel.class);
        user.setId(this.userService.getLoggedUserId(user.getUsername()));

        this.wordService.addWord(word, user);

        return "redirect:/home";
    }
}

