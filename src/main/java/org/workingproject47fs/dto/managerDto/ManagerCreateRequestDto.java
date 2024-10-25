package org.workingproject47fs.dto.managerDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.workingproject47fs.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerCreateRequestDto {

    @NotBlank(message = "Manager name не должен быть пустой")
    @Size(min = 3, max = 15)
    private String managerName;

    private String password;

    @Email(message = "Некорректный формат email")
    private String email;

}
