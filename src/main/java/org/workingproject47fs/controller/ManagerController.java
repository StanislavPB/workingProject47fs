package org.workingproject47fs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.workingproject47fs.dto.GeneralResponse;
import org.workingproject47fs.dto.managerDto.ManagerCreateRequestDto;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.service.ManagerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/managers")
public class ManagerController {

    private final ManagerService service;

    @PostMapping
    public GeneralResponse<ManagerResponseDto> createNewManager(@RequestBody ManagerCreateRequestDto request){
        return service.createNewManager(request);
    }

    @GetMapping
    public List<ManagerResponseDto> findAll(){
        return service.findAll();
    }

    @GetMapping("/full")
    public List<Manager> findAllFull(){
        return service.findAllFullDetails();
    }

    @GetMapping("/email")
    public GeneralResponse<ManagerResponseDto> findManagerByEmail(@RequestParam String email){
        return service.findManagerByEmail(email);
    }

}
