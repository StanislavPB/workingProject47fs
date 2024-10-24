package org.workingproject47fs.databaseMigration.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
//@Component
public class StartRunner implements CommandLineRunner {

    private FillDatabase fillDatabase;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Load roles into database table ...");
        fillDatabase.fillRoleTable();
        System.out.println("Done ...");
    }
}
