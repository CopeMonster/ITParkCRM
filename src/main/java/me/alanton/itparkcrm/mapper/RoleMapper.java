package me.alanton.itparkcrm.mapper;

import me.alanton.itparkcrm.dto.response.RoleResponse;
import me.alanton.itparkcrm.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    RoleResponse toRoleResponse(Role role);
}
