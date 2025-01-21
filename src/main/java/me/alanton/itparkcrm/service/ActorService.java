package me.alanton.itparkcrm.service;

import me.alanton.itparkcrm.dto.request.ActorRequest;
import me.alanton.itparkcrm.dto.response.ActorResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface ActorService extends UserDetailsService {
    ActorResponse getActorById(UUID id);
    ActorResponse getActorByEmail(String email);
    Page<ActorResponse> getAllActors(Pageable pageable);
    ActorResponse saveActor(ActorRequest actorRequest);
    ActorResponse updateActor(UUID id, ActorRequest actorRequest);
    void deleteActor(UUID id);
    boolean isExistByEmail(String email);
    boolean isExistById(UUID id);
}
