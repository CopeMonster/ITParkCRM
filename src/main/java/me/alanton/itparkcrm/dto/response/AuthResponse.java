package me.alanton.itparkcrm.dto.response;

public record AuthResponse(
        String accessToken,
        String refreshToken
) {
}
