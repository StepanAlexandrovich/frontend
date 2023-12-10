package com.example.frontend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    //@Size(min = 8,max = 20,message = "Field must be не попадает в пределы 8 - 20 знаков")
    private String username;
    //@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$",message = "НУЖЕН ХОТЯ БЫ ОДИН СИМВОЛ И ОДНА ЦИФРА В НИЖНЕМ РЕГИСТРЕ")
    private String password;
}
