package ru.kukulo1.user_service.service;

import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kukulo1.user_service.entity.Role;
import ru.kukulo1.user_service.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Nullable
    public Role getRole(Long id) {
        return roleRepository.findById(id).orElse(null);
    }

    @Nullable
    public Role getRole(String name) {
        return roleRepository.findByName(name).orElse(null);
    }

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
