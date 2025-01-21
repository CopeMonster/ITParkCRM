package me.alanton.itparkcrm.controller;

import lombok.RequiredArgsConstructor;
import me.alanton.itparkcrm.dto.request.SignInRequest;
import me.alanton.itparkcrm.dto.request.SignUpRequest;
import me.alanton.itparkcrm.dto.response.ActorResponse;
import me.alanton.itparkcrm.dto.response.AuthResponse;
import me.alanton.itparkcrm.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signIn(@RequestBody SignInRequest signInRequest) {
        AuthResponse authResponse = authService.signIn(signInRequest);

        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/sign-up")
    public ResponseEntity<ActorResponse> signUp(@RequestBody SignUpRequest signUpRequest) {
        ActorResponse actorResponse = authService.signUp(signUpRequest);

        return ResponseEntity.ok(actorResponse);
    }
}
