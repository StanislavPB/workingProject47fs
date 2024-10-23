package org.workingproject47fs.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.TaskStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskResponseDto {

    private Integer id;
    private String taskName;
    private String taskDescription;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;
    private LocalDateTime deadline;
    private TaskStatus status;

    private ManagerResponseDto managerResponseDto;
    /*
    private String managerName
    это если достаточно краткой информации о менеджере
    или использует dto для развернутой информации
     */


}
