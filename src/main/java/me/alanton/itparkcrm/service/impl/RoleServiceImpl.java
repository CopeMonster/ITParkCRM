package me.alanton.itparkcrm.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import me.alanton.itparkcrm.dto.request.RoleRequest;
import me.alanton.itparkcrm.dto.response.RoleResponse;
import me.alanton.itparkcrm.entity.Role;
import me.alanton.itparkcrm.exception.impl.BusinessException;
import me.alanton.itparkcrm.exception.impl.BusinessExceptionReason;
import me.alanton.itparkcrm.mapper.RoleMapper;
import me.alanton.itparkcrm.repository.RoleRepository;
import me.alanton.itparkcrm.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
public class RoleServiceImpl implements RoleService {
    final RoleRepository roleRepository;
    final RoleMapper roleMapper;

    @Override
    public RoleResponse getRoleByName(String name) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> {
                    // TODO: add exception logging
                    return new BusinessException(BusinessExceptionReason.ROLE_NOT_FOUND_EXCEPTION);
                });

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        List<Role> roles = roleRepository.findAll();

        return roles.stream()
                .map(roleMapper::toRoleResponse)
                .toList();
    }

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {
        Role role = Role.builder()
                .name(roleRequest.name())
                .build();

        roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public RoleResponse updateRole(String name, RoleRequest roleRequest) {
        Role role = roleRepository.findByName(name)
                .orElseThrow(() -> {
                    // TODO: add exception logging
                    return new BusinessException(BusinessExceptionReason.ROLE_NOT_FOUND_EXCEPTION);
                });

        role.setName(roleRequest.name());

        roleRepository.save(role);

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public void deleteRole(String name) {
        roleRepository.findByName(name)
                .orElseThrow(() -> {
                    // TODO: add exception logging
                    return new BusinessException(BusinessExceptionReason.ROLE_NOT_FOUND_EXCEPTION);
                });

        roleRepository.deleteByName(name);
    }

    @Override
    public boolean isExistByName(String name) {
        return roleRepository.existsByName(name);
    }
}
