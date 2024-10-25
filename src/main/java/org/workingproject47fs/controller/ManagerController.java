package org.workingproject47fs.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.workingproject47fs.controller.api.ManagerControllerApi;
import org.workingproject47fs.dto.managerDto.ManagerCreateRequestDto;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.service.ManagerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ManagerController implements ManagerControllerApi {

    private final ManagerService service;


    @PostMapping
    public ResponseEntity<ManagerResponseDto> createNewManager(@Valid @RequestBody ManagerCreateRequestDto request){
        return new ResponseEntity<>(service.createNewManager(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ManagerResponseDto>> findAll(){
        return new ResponseEntity<>(service.findAll(),HttpStatus.OK);
    }

    @GetMapping("/full")
    public ResponseEntity<List<Manager>> findAllFull(){
        return ResponseEntity.ok(service.findAllFullDetails());
    }

    @GetMapping("/email")
    public ResponseEntity<ManagerResponseDto> findManagerByEmail(@RequestParam String email){
        return ResponseEntity.ok(service.findManagerByEmail(email));
    }

}
