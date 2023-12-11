package com.example.frontend.controllers;

import com.example.frontend.models.User;
import com.example.frontend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class FirstController {
    private final UserRepository userRepository;

    @GetMapping("/test")
    public String test(Principal principal){
        String login = (String) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();
        User byLogin = userRepository.findByLogin(login);

        return "test";
    }
}
