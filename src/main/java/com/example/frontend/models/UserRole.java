package com.example.frontend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole implements GrantedAuthority {
    private Long id;
    private String role;

    @Override
    public String getAuthority() {
        return role;
    }
}
