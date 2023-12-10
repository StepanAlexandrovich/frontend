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
public class UserRepository {
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(Long id,String login,String password){
        String passwordEncoded = passwordEncoder.encode(password);
        return new User(id,login,passwordEncoded,Set.of(new UserRole(1L,"ROLE_USER")));
    }

    public List<User> findAll(){
//        return List.of(
//                new User(1L,"user1","1",Set.of(new UserRole(1L,"ROLE_USER"))),
//                new User(2L,"user2","2",Set.of(new UserRole(1L,"ROLE_USER"))),
//                new User(3L,"user3","3",Set.of(new UserRole(1L,"ROLE_USER"))));

        return List.of(
                createUser(1L,"user1","1"),
                createUser(2L,"user2","2"),
                createUser(3L,"user3","3")
                );
    }

    public User findByLogin(String login){
        return findAll().stream().filter(user -> user.getLogin().equals(login)).findFirst().orElse(null);
    }
}
