package org.workingproject47fs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.Role;

import java.util.List;
import java.util.Optional;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {

    Optional<Manager> findByEmail(String email);

    List<Manager> findByManagerName(String managerName);

    List<Manager> findByRole(Role role);


}
