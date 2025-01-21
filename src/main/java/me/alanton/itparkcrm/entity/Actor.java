package me.alanton.itparkcrm.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "actor")
public class Actor extends BaseModel {
    @Column(name = "first_name", nullable = false)
    String firstname;

    @Column(name = "last_name", nullable = false)
    String lastname;

    @Column(name = "email", unique = true, nullable = false)
    String email;

    @Column(name = "password", nullable = false)
    String password;

    @ManyToMany
    @JoinTable(
            name = "actor_role",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<Role> roles;
}
