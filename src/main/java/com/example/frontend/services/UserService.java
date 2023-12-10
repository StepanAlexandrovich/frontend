package com.example.frontend.services;

import com.example.frontend.dto.UserCreateDto;
import com.example.frontend.repositories.UserRepository;
import com.example.frontend.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

//    public User createUser(UserCreateDto userCreateDto) {
//    }


}
