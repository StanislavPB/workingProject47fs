package org.workingproject47fs.service.util;

import org.springframework.stereotype.Component;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.dto.taskDto.TaskCreateRequestDto;
import org.workingproject47fs.dto.taskDto.TaskResponseDto;
import org.workingproject47fs.entity.Task;

@Component
public class TaskConverter {


    public Task fromDto(TaskCreateRequestDto dto) {
        Task task = new Task();

        task.setTaskName(dto.getTaskName());
        task.setTaskDescription(dto.getTaskDescription());
        task.setDeadline(dto.getDeadline());

        return task;
    }

    public TaskResponseDto toDto(Task task) {
        TaskResponseDto dto = new TaskResponseDto();
        dto.setId(task.getId());
        dto.setTaskName(task.getTaskName());
        dto.setTaskDescription(task.getTaskDescription());
        dto.setCreateDate(task.getCreateDate());
        dto.setLastUpdate(task.getLastUpdate());
        dto.setDeadline(task.getDeadline());
        dto.setStatus(task.getStatus());

        ManagerResponseDto managerResponseDto = new ManagerResponseDto(
                task.getManager().getId(),
                task.getManager().getManagerName(),
                task.getManager().getEmail(),
                task.getManager().getRole()
        );


        dto.setManagerResponseDto(managerResponseDto);


        return dto;


    }

}
