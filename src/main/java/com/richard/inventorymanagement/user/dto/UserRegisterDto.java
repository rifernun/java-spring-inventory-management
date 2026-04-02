package com.richard.inventorymanagement.user.dto;


import jakarta.validation.constraints.Pattern;

public record UserRegisterDto(String email,
                              String fullName,
                              @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).+$", message = "Password must contain at least one uppercase letter, one special character and a number!") String password) {
}
