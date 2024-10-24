package org.workingproject47fs.databaseMigration.v1;


import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.workingproject47fs.entity.Role;
import org.workingproject47fs.repository.RoleRepository;

@Data
@RequiredArgsConstructor
//@Component
public class FillDatabase {
    private final RoleRepository repository;

    public void fillRoleTable(){
        Role admin = new Role("ADMIN");
        repository.save(admin);

        Role user = new Role("USER");
        repository.save(user);

    }
}
