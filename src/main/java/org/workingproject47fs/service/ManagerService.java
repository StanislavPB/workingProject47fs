package org.workingproject47fs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.workingproject47fs.dto.GeneralResponse;
import org.workingproject47fs.dto.managerDto.ManagerCreateRequestDto;
import org.workingproject47fs.dto.managerDto.ManagerResponseDto;
import org.workingproject47fs.entity.Manager;
import org.workingproject47fs.entity.Role;
import org.workingproject47fs.repository.ManagerRepository;
import org.workingproject47fs.repository.RoleRepository;
import org.workingproject47fs.service.exception.AlreadyExistException;
import org.workingproject47fs.service.exception.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ManagerService {

    private final ManagerRepository managerRepository;
    private final RoleRepository roleRepository;


    public ManagerResponseDto createNewManager(ManagerCreateRequestDto request){

        if (checkIsExistManager(request.getEmail())){
            throw new AlreadyExistException("Пользователь с email " + request.getEmail() + " уже зарегистрирован");
        }

        Manager newManager = createManagerFromDto(request);

        Manager savedManager = managerRepository.save(newManager);

        ManagerResponseDto response = createDtoFromManager(savedManager);

        return response;

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

    public ManagerResponseDto findManagerByEmail(String email){

        Optional<Manager> managerOptional = managerRepository.findByEmail(email);

        if (managerOptional.isPresent()) {
            ManagerResponseDto response = createDtoFromManager(managerOptional.get());
            return response;
        } else {
            throw new NotFoundException("Manager with email " + email + " not found");
        }

    }

    public Optional<Manager> findManagerByEmailForCreateTsk(String email){

    return managerRepository.findByEmail(email);


    }

    public List<Manager> findAllFullDetails() {
        return managerRepository.findAll();
    }


}
