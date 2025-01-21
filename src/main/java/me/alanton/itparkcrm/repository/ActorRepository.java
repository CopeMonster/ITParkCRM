package me.alanton.itparkcrm.repository;

import me.alanton.itparkcrm.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ActorRepository extends JpaRepository<Actor, UUID> {
    Optional<Actor> findByEmail(String email);

    boolean existsByEmail(String email);
}
