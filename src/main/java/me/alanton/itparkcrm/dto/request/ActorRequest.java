package me.alanton.itparkcrm.dto.request;

import lombok.Builder;

import java.util.Set;

@Builder
public record ActorRequest(
        String firstname,
        String lastname,
        String email,
        String password,
        Set<RoleRequest> roles
) {
}
