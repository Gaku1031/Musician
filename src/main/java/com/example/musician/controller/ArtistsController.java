package com.example.musician.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.musician.entity.Artist;
import com.example.musician.entity.Artist.Authority;
import com.example.musician.form.UserForm;
import com.example.musician.repository.ArtistRepository;

@Controller
public class ArtistsController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ArtistRepository repository;

    @GetMapping(path = "/artists/new")
    public String newUser(Model model) {
        model.addAttribute("form", new UserForm());
        return "artists/new";
    }

    @RequestMapping(value = "/artist", method = RequestMethod.POST)
    public String create(@Validated @ModelAttribute("form") UserForm form, BindingResult result, Model model, RedirectAttributes redirAttrs) {
        String name = form.getName();
        String email = form.getEmail();
        String password = form.getPassword();
        String passwordConfirmation = form.getPasswordConfirmation();

        if (repository.findByArtistname(email) != null) {
            FieldError fieldError = new FieldError(result.getObjectName(), "email", "その E メールはすでに使用されています。");
            result.addError(fieldError);
        }
        if (result.hasErrors()) {
        	model.addAttribute("hasMessage", true);
        	model.addAttribute("class", "alert-danger");
        	model.addAttribute("message", "アーティスト登録に失敗しました。");
            return "artists/new";
        }

        Artist entity = new Artist(email, name, passwordEncoder.encode(password), Authority.ROLE_ARTIST);
        repository.saveAndFlush(entity);

        model.addAttribute("hasMessage", true);
        model.addAttribute("class", "alert-info");
        model.addAttribute("message", "アーティスト登録が完了しました。");
        return "layouts/complete";
    }
}