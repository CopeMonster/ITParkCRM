package me.alanton.itparkcrm.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.alanton.itparkcrm.dto.request.ActorRequest;
import me.alanton.itparkcrm.dto.request.RoleRequest;
import me.alanton.itparkcrm.dto.request.SignInRequest;
import me.alanton.itparkcrm.dto.request.SignUpRequest;
import me.alanton.itparkcrm.dto.response.ActorResponse;
import me.alanton.itparkcrm.dto.response.AuthResponse;
import me.alanton.itparkcrm.entity.Actor;
import me.alanton.itparkcrm.repository.ActorRepository;
import me.alanton.itparkcrm.security.JwtUtils;
import me.alanton.itparkcrm.service.ActorService;
import me.alanton.itparkcrm.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Service
public class AuthServiceImpl implements AuthService {
    final ActorRepository actorRepository;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;
    private final ActorService actorService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse signIn(SignInRequest signInRequest) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                signInRequest.email(),
                signInRequest.password()
        ));

        UserDetails user = actorService.loadUserByUsername(signInRequest.email());

        String accessToken = jwtUtils.generateAccessToken(user);
        String refreshToken = jwtUtils.generateRefreshToken(user);

        return new AuthResponse(accessToken, refreshToken);
    }

    @Override
    public ActorResponse signUp(SignUpRequest signUpRequest) {
        ActorRequest actorRequest = ActorRequest.builder()
                .firstname(signUpRequest.firstname())
                .lastname(signUpRequest.lastname())
                .email(signUpRequest.email())
                .password(passwordEncoder.encode(signUpRequest.password()))
                .roles(Set.of(new RoleRequest("MEMBER")))
                .build();

        return actorService.saveActor(actorRequest);
    }
}
