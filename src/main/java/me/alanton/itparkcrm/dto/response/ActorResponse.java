package me.alanton.itparkcrm.dto.response;

import lombok.Builder;

import java.util.Set;
import java.util.UUID;

@Builder
public record ActorResponse(
        UUID id,
        String firstname,
        String lastname,
        String email,
        Set<RoleResponse> roles
) {
}
