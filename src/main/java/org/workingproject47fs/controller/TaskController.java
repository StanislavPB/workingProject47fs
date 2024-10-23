package org.workingproject47fs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.workingproject47fs.dto.GeneralResponse;
import org.workingproject47fs.dto.taskDto.TaskCreateRequestDto;
import org.workingproject47fs.dto.taskDto.TaskResponseDto;
import org.workingproject47fs.entity.Task;
import org.workingproject47fs.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService service;


    @PostMapping
    public GeneralResponse<TaskResponseDto> createTask(@RequestBody TaskCreateRequestDto request){
        return service.createTask(request);
    }

    @GetMapping
    public List<TaskResponseDto> findAll(){
        return service.findAll();
    }


    @GetMapping("/full")
    public List<Task> findAllFull(){
        return service.findAllFullTaskDetail();
    }


}
