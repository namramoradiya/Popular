package com.personality.individual.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.personality.individual.Entity.UserProfile;
import com.personality.individual.service.UserProfileService;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserProfileService service;

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("userProfile", new UserProfile());
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(@ModelAttribute UserProfile userProfile,
                             Model model,
                             HttpSession session) {

        UserProfile savedUser = service.saveUser(userProfile);

        session.setAttribute("userId", savedUser.getId());

        model.addAttribute("name", savedUser.getName());
        model.addAttribute("userProfile", new UserProfile());

        return "index";
    }


    @PostMapping("/show-favourites")
    public String showFavourites(HttpSession session, Model model) {

        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            model.addAttribute("error", "Please submit form first");
            model.addAttribute("userProfile",new UserProfile());
            return "index";
        }

        UserProfile user = service.getUserById(userId);
        model.addAttribute("favourites", user);
        model.addAttribute("userProfile", new UserProfile());

        return "index";
    }


}

