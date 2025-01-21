package me.alanton.itparkcrm.mapper;

import me.alanton.itparkcrm.dto.response.ActorResponse;
import me.alanton.itparkcrm.entity.Actor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ActorMapper {
    ActorResponse toActorResponse(Actor actor);
}
