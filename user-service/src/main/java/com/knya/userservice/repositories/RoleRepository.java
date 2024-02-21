package com.knya.userservice.repositories;

import com.knya.userservice.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByTag(String tag);
    Optional<Role> findById(Long id);
}
