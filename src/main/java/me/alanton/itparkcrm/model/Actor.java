package me.alanton.itparkcrm.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

@Entity
@Table(name = "actors")
public class Actor extends BaseModel {
    private String firstname;

    private String lastname;

    private String email;

    private String password;

    private Set<Role> roles;
}
