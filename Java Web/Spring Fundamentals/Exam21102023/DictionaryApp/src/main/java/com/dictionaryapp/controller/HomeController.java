package com.dictionaryapp.controller;

import com.dictionaryapp.model.entity.LanguageEnum;
import com.dictionaryapp.model.view.WordViewModel;
import com.dictionaryapp.service.WordService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.Collection;

@Controller
public class HomeController {

    private final WordService wordService;
    private final HttpSession httpSession;

    public HomeController(WordService wordService, HttpSession httpSession) {
        this.wordService = wordService;
        this.httpSession = httpSession;
    }

    @GetMapping("/home")
    public String home(Model model) {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        Collection<WordViewModel> germanWords = this.wordService.getAllWordsByLanguage(LanguageEnum.GERMAN);
        Collection<WordViewModel> spanishWords = this.wordService.getAllWordsByLanguage(LanguageEnum.SPANISH);
        Collection<WordViewModel> frenchWords = this.wordService.getAllWordsByLanguage(LanguageEnum.FRENCH);
        Collection<WordViewModel> italianWords = this.wordService.getAllWordsByLanguage(LanguageEnum.ITALIAN);

        model.addAttribute("germanWords", germanWords);
        model.addAttribute("spanishWords", spanishWords);
        model.addAttribute("frenchWords", frenchWords);
        model.addAttribute("italianWords", italianWords);

        return "/home";
    }

    @PostMapping("/home/remove-all")
    public String removeAll() {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        this.wordService.removeAllWords();
        return "redirect:/home";
    }

    @GetMapping(value = "/remove-current-word/{langId}")
    public String removeCurrentLang(@PathVariable Long langId) {
        if (this.httpSession.getAttribute("user") == null) {
            return "redirect:/";
        }

        this.wordService.removeWordById(langId);
        return "redirect:/home";
    }
}
