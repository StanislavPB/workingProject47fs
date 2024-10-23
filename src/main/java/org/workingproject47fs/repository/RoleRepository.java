package org.workingproject47fs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.workingproject47fs.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByName(String name);

}
