package org.workingproject47fs.dto.managerDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.workingproject47fs.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerResponseDto {

    private Integer id;
    private String managerName;
    private String email;
    private Role role;

}
