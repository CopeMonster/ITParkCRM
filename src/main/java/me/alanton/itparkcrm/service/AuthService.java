package me.alanton.itparkcrm.service;

import me.alanton.itparkcrm.dto.request.SignInRequest;
import me.alanton.itparkcrm.dto.request.SignUpRequest;
import me.alanton.itparkcrm.dto.response.ActorResponse;
import me.alanton.itparkcrm.dto.response.AuthResponse;

public interface AuthService {
    AuthResponse signIn(SignInRequest signInRequest);
    ActorResponse signUp(SignUpRequest signUpRequest);
}
