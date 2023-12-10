package com.example.frontend.controllers;

import com.example.frontend.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.security.Principal;

@Controller
public class EnterController {

    @GetMapping("/login")
    public String enter(){

        return "login";
    }

    @GetMapping("/user/menu")
    public String menu(Model model, Principal principal){
        User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        model.addAttribute("user",user);
        return "menu";
    }

}
