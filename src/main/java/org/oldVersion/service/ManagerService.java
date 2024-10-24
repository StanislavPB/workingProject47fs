package org.oldVersion.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.workingproject47fs.dto.GeneralResponse;
import org.workingproject47fs.dto.managerDto.ManagerCreateRequestDto;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.Role;
import org.workingproject47fs.repository.ManagerRepository;
import org.workingproject47fs.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final RoleRepository roleRepository;


    public GeneralResponse<ManagerResponseDto> createNewManager(ManagerCreateRequestDto request){

        if (checkIsExistManager(request.getEmail())){
            GeneralResponse<ManagerResponseDto> response = new GeneralResponse<>(null,new ArrayList<>());
            response.addError("Пользователь с email " + request.getEmail() + " уже зарегистрирован");
            return response;
        }

        Manager newManager = createManagerFromDto(request);

        Manager savedManager = managerRepository.save(newManager);

        ManagerResponseDto response = createDtoFromManager(savedManager);

        return new GeneralResponse<>(response,new ArrayList<>());

    }

    private boolean checkIsExistManager(String email){
        Optional<Manager> existManager = managerRepository.findByEmail(email);
        return existManager.isPresent();
    }

    private Manager createManagerFromDto(ManagerCreateRequestDto request){
        Manager newManager = new Manager();
        newManager.setManagerName(request.getManagerName());
        newManager.setEmail(request.getEmail());
        newManager.setPassword(request.getPassword());

        Optional<Role> defaultRole = roleRepository.findByName("USER");
        newManager.setRole(defaultRole.get());

        return newManager;

    }

    private ManagerResponseDto createDtoFromManager(Manager manager){
        return new ManagerResponseDto(manager.getId(), manager.getManagerName(), manager.getEmail(), manager.getRole());
    }


    public List<ManagerResponseDto> findAll(){
        return managerRepository.findAll().stream()
                .map(manager -> createDtoFromManager(manager))
                .toList();
    }

    public GeneralResponse<ManagerResponseDto> findManagerByEmail(String email){

        Optional<Manager> managerOptional = managerRepository.findByEmail(email);

        if (managerOptional.isPresent()) {
            ManagerResponseDto response = createDtoFromManager(managerOptional.get());
            return new GeneralResponse<>(response,new ArrayList<>());
        } else {
            GeneralResponse<ManagerResponseDto> generalResponse = new GeneralResponse<>(null,new ArrayList<>());
            generalResponse.addError("Manager with email " + email + " not found");
            return generalResponse;
        }

    }

    public Optional<Manager> findManagerByEmailForCreateTsk(String email){

    return managerRepository.findByEmail(email);


    }

    public List<Manager> findAllFullDetails() {
        return managerRepository.findAll();
    }


}
