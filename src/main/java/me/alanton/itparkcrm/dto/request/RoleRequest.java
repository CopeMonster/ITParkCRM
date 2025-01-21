package me.alanton.itparkcrm.dto.request;

import jakarta.validation.constraints.NotBlank;

public record RoleRequest(
        @NotBlank(message = "Role name must not be blank")
        String name
) {
}
