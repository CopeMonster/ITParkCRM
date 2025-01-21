package me.alanton.itparkcrm.service.impl;

import me.alanton.itparkcrm.dto.request.RoleRequest;
import me.alanton.itparkcrm.dto.response.RoleResponse;
import me.alanton.itparkcrm.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Override
    public RoleResponse getRoleByName(String name) {
        return null;
    }

    @Override
    public List<RoleResponse> getAllRoles() {
        return List.of();
    }

    @Override
    public RoleResponse createRole(RoleRequest roleRequest) {
        return null;
    }

    @Override
    public RoleResponse updateRole(String name, RoleRequest roleRequest) {
        return null;
    }

    @Override
    public void deleteRole(String name) {

    }

    @Override
    public boolean isExistByName(String name) {
        return false;
    }
}
