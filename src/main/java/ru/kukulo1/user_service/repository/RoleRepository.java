package ru.kukulo1.user_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kukulo1.user_service.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
