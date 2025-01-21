package me.alanton.itparkcrm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
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
@Table(name = "role")
public class Role extends BaseModel {
    String name;

    @ManyToMany(mappedBy = "roles")
    Set<Actor> actors;
}
