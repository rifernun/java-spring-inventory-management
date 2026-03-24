package com.richard.inventorymanagement.user.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDto {
    private String name;
    private String email;
    private String password;
}
