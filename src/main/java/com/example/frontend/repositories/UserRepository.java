package com.example.frontend.repositories;

import com.example.frontend.models.User;
import com.example.frontend.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    //private final PasswordEncoder passwordEncoder;


    public List<User> findAll(){
        return List.of(
                new User(1L,"user1","$2a$12$4YcA.BscCJIz2MS.kjub4uTaCtQc5P4W03wMMfe53eFRKK0LaEdTS",Set.of(new UserRole(1L,"ROLE_USER"))),
                new User(2L,"user2","2",Set.of(new UserRole(1L,"ROLE_USER"))),
                new User(3L,"user3","3",Set.of(new UserRole(1L,"ROLE_USER"))));
    }

    public User findByLogin(String login){
        return findAll().stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }
}
