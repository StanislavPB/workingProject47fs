package org.workingproject47fs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskCreateRequestDto request){
        return new ResponseEntity<>(service.createTask(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }


    @GetMapping("/full")
    public ResponseEntity<List<Task>> findAllFull(){
        return ResponseEntity.ok(service.findAllFullTaskDetail());
    }


}
