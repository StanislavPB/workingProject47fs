package org.workingproject47fs.dto.taskDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.TaskStatus;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskCreateRequestDto {

    private String taskName;
    private String taskDescription;
    private LocalDateTime deadline;
    private String managerEmail;

}
