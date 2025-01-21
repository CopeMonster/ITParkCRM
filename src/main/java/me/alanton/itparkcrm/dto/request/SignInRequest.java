package me.alanton.itparkcrm.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

@Builder
public record SignInRequest(
        @NotBlank(message = "Email must not be empty")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Email must not be empty")
        @Size(min = 8, max = 255, message = "Password must be at least 8 characters long")
        String password
) {
}
