package com.example.frontend.controllers;

import com.example.frontend.dto.UserCreateDto;
import com.example.frontend.models.User;
import com.example.frontend.repositories.UserRepository;
import com.example.frontend.services.CustomUserDetailsService;
import com.example.frontend.services.JwtTokenUtils;
import com.example.frontend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailsService customUserDetailsService;
    private final UserService userService;

    private final JwtTokenUtils jwtTokenUtils;

    @GetMapping("/users")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/authentication")
    public ResponseEntity<?> authentication(@RequestBody UserCreateDto userCreateDto){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userCreateDto.getUsername(),userCreateDto.getPassword()));
        }catch (Exception e){
            return new ResponseEntity<>("bad username or password", HttpStatus.UNAUTHORIZED);
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userCreateDto.getUsername());
        String token = jwtTokenUtils.generationToken(userDetails);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

}
