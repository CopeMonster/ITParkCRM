package me.alanton.itparkcrm.service.impl;

import lombok.RequiredArgsConstructor;
import me.alanton.itparkcrm.dto.request.ActorRequest;
import me.alanton.itparkcrm.dto.response.ActorResponse;
import me.alanton.itparkcrm.entity.Actor;
import me.alanton.itparkcrm.entity.Role;
import me.alanton.itparkcrm.exception.impl.BusinessException;
import me.alanton.itparkcrm.exception.impl.BusinessExceptionReason;
import me.alanton.itparkcrm.mapper.ActorMapper;
import me.alanton.itparkcrm.repository.ActorRepository;
import me.alanton.itparkcrm.repository.RoleRepository;
import me.alanton.itparkcrm.service.ActorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Service
public class ActorServiceImpl implements ActorService {
    private final ActorRepository actorRepository;
    private final ActorMapper actorMapper;
    private final RoleRepository roleRepository;

    @Override
    public ActorResponse getActorById(UUID id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> {
                    return new BusinessException(BusinessExceptionReason.ACTOR_NOT_FOUND_EXCEPTION);
                });

        return actorMapper.toActorResponse(actor);
    }

    @Override
    public ActorResponse getActorByEmail(String email) {
        Actor actor = actorRepository.findByEmail(email)
                .orElseThrow(() -> {
                    return new BusinessException(BusinessExceptionReason.ACTOR_NOT_FOUND_EXCEPTION);
                });

        return actorMapper.toActorResponse(actor);
    }

    @Override
    public Page<ActorResponse> getAllActors(Pageable pageable) {
        Page<Actor> actors = actorRepository.findAll(pageable);

        return actors.map(actorMapper::toActorResponse);
    }

    @Override
    public ActorResponse saveActor(ActorRequest actorRequest) {
        Set<Role> roles = actorRequest.roles().stream()
                .map(roleRequest ->
                        roleRepository.findByName(roleRequest.name())
                                .orElseThrow(() -> {
                                    return new BusinessException(BusinessExceptionReason.ROLE_NOT_FOUND_EXCEPTION);
                                }))
                .collect(Collectors.toSet());


        Actor actor = Actor.builder()
                .firstname(actorRequest.firstname())
                .lastname(actorRequest.lastname())
                .email(actorRequest.email())
                .password(actorRequest.password())
                .roles(roles)
                .build();

        actorRepository.save(actor);

        return actorMapper.toActorResponse(actor);
    }

    @Override
    public ActorResponse updateActor(UUID id, ActorRequest actorRequest) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> {
                    return new BusinessException(BusinessExceptionReason.ACTOR_NOT_FOUND_EXCEPTION);
                });

        actor.setFirstname(actor.getFirstname());
        actor.setLastname(actor.getLastname());

        actorRepository.save(actor);

        return actorMapper.toActorResponse(actor);
    }

    @Override
    public void deleteActor(UUID id) {
        actorRepository.findById(id)
                .orElseThrow(() -> {
                    return new BusinessException(BusinessExceptionReason.ACTOR_NOT_FOUND_EXCEPTION);
                });

        actorRepository.deleteById(id);
    }

    @Override
    public boolean isExistByEmail(String email) {
        return actorRepository.existsByEmail(email);
    }

    @Override
    public boolean isExistById(UUID id) {
        return actorRepository.existsById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: add exception logging

        return actorRepository.findByEmail(username)
                .orElseThrow(() -> {
                    // TODO: add exception logging
                    return new BusinessException(BusinessExceptionReason.ACTOR_NOT_FOUND_EXCEPTION);
                });
    }
}
