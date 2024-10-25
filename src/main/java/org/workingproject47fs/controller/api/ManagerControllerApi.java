package org.workingproject47fs.controller.api;

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
import org.workingproject47fs.dto.managerDto.ManagerCreateRequestDto;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.service.ManagerService;

import java.util.List;

@RestController
@RequestMapping("/api/managers")
public interface ManagerControllerApi {


    @Operation(summary = "Регистрация нового менеджера", description = "Операция доступна всем, роль по умолчанию - USER")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Менеджер успешно зарегистрирован",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ManagerResponseDto.class))),
            @ApiResponse(responseCode = "400", description = "Ошибка валидации",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class)))
    }
    )
    @PostMapping
    public ResponseEntity<ManagerResponseDto> createNewManager(@Valid @RequestBody ManagerCreateRequestDto request);

    @GetMapping
    public ResponseEntity<List<ManagerResponseDto>> findAll();

    @GetMapping("/full")
    public ResponseEntity<List<Manager>> findAllFull();

    @GetMapping("/email")
    public ResponseEntity<ManagerResponseDto> findManagerByEmail(@RequestParam String email);

}
