package com.example.portfolio.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data

public class Contact {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 Characters!")
    String name;

    @NotBlank(message = "Email is Required!")
    @Email(message = "Enter a Valid Email!")
    String email;

    @NotBlank(message = "Message cannot be empty.")
    @Size(min = 10, max = 500, message = "Message must be between 10 and 500 characters!.")
    String message;
}
