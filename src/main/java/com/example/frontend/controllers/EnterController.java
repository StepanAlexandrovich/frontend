package com.example.frontend.controllers;

import com.example.frontend.models.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class EnterController {

    @GetMapping("/login")
    public String enter(){

        return "login";
    }

    @GetMapping("/user/menu")
    public String menu(){
        //User user = ((User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal());
        Object principal1 = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return "menu";
    }

}
