package org.workingproject47fs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.workingproject47fs.dto.GeneralResponse;
import org.workingproject47fs.dto.taskDto.TaskCreateRequestDto;
import org.workingproject47fs.dto.taskDto.TaskResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.Task;
import org.workingproject47fs.entity.TaskStatus;
import org.workingproject47fs.repository.TaskRepository;
import org.workingproject47fs.service.exception.NotFoundException;
import org.workingproject47fs.service.util.TaskConverter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;
    private final ManagerService managerService;
    private final TaskConverter converter;

    public TaskResponseDto createTask(TaskCreateRequestDto dto){

        Optional<Manager> managerOptional = managerService.findManagerByEmailForCreateTsk(dto.getManagerEmail());

        if (managerOptional.isEmpty()) {
            throw new NotFoundException("Manager with email " + dto.getManagerEmail() + " not found");
        }

        Task newTask = converter.fromDto(dto);

        LocalDateTime currentTime = LocalDateTime.now();
        newTask.setCreateDate(currentTime);
        newTask.setLastUpdate(currentTime);
        newTask.setStatus(TaskStatus.OPEN);
        newTask.setManager(managerOptional.get());

        repository.save(newTask);

        TaskResponseDto response = converter.toDto(newTask);

        return response;
    }

    // поиск всех

    public List<TaskResponseDto> findAll(){
        return repository.findAll().stream()
                .map(task -> converter.toDto(task))
                .toList();
    }

    // поиск по менеджеру

    public List<TaskResponseDto> findTasksByManagerEmail(String managerEmail){
        Optional<Manager> managerOptional = managerService.findManagerByEmailForCreateTsk(managerEmail);

        if (managerOptional.isEmpty()) {
            throw new NotFoundException("Manager with email " + managerEmail + " not found");

        }

        Manager manager = managerOptional.get();


        List<TaskResponseDto> taskResponseDtos = repository.findByManager(manager).stream()
                .map(task -> converter.toDto(task))
                .toList();

        return taskResponseDtos;
    }


    public List<Task> findAllFullTaskDetail(){
        return repository.findAll();
    }


}
