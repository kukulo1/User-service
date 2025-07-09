package ru.kukulo1.user_service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kukulo1.user_service.entity.Role;
import ru.kukulo1.user_service.repository.RoleRepository;

@Component
@RequiredArgsConstructor
public class RoleInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void initializeRoles() {
        createRoleIfNotExists(1L, "ROLE_USER");
        createRoleIfNotExists(2L, "ROLE_ADMIN");
    }

    private void createRoleIfNotExists(Long id, String roleName) {
        if (!roleRepository.existsByName(roleName)) {
            Role role = new Role();
            role.setId(id);
            role.setName(roleName);
            roleRepository.save(role);
        }
    }
}
