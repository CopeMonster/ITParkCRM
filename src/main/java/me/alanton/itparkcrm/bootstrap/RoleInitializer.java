package me.alanton.itparkcrm.bootstrap;

import lombok.RequiredArgsConstructor;
import me.alanton.itparkcrm.dto.request.RoleRequest;
import me.alanton.itparkcrm.service.RoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RoleInitializer implements CommandLineRunner {
    private final RoleService roleService;

    private final String[] defaultRoles = {
            "MEMBER",
            "TEAM_LEAD",
            "ADMIN"
    };

    @Override
    public void run(String... args) throws Exception {
        for (String roleName : defaultRoles) {

            if (!roleService.isExistByName(roleName)) {
                RoleRequest role = new RoleRequest(roleName);

                roleService.createRole(role);
            }
        }
    }
}
