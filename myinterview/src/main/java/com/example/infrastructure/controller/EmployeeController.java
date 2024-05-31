package com.example.infrastructure.controller;

import com.example.application.dto.EmployeeRequestDTO;
import com.example.application.dto.EmployeeResponseDTO;
import com.example.application.usecases.EmployeeInteractor;
import com.example.domain.entity.Employee;
import com.example.infrastructure.DTOMapper.EmployeeDTOMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeInteractor employeeInteractor;
    private final EmployeeDTOMapper employeeDTOMapper;
    public EmployeeController(EmployeeInteractor employeeInteractor, EmployeeDTOMapper employeeDTOMapper) {
        this.employeeInteractor = employeeInteractor;
        this.employeeDTOMapper = employeeDTOMapper;
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDTO> create(@RequestBody EmployeeRequestDTO requestDTO) {
        Employee employee = this.employeeDTOMapper.requestDTOToObjectDomain(requestDTO);
         EmployeeResponseDTO responseDTO = this.employeeDTOMapper.objectDoaminToResponseDTO(this.employeeInteractor.createEmployee(employee));
        return ResponseEntity.ok(responseDTO);
    }

    @PutMapping
    public ResponseEntity<EmployeeResponseDTO> update(@RequestBody EmployeeResponseDTO responseDTO) {
        Employee employee = this.employeeDTOMapper.responseDTOToObjectDomain(responseDTO);
        EmployeeResponseDTO response = this.employeeDTOMapper.objectDoaminToResponseDTO(this.employeeInteractor.updateEmployee(employee));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody EmployeeResponseDTO responseDTO) {
        Employee employee = this.employeeDTOMapper.responseDTOToObjectDomain(responseDTO);
        this.employeeInteractor.deleteEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDTO>> getAllEmployees() {
        List<Employee> employees = this.employeeInteractor.getAllEmployees();
        List<EmployeeResponseDTO> responseDTOs = employees.stream().map(this.employeeDTOMapper::objectDoaminToResponseDTO).toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{empNo}")
    public ResponseEntity<EmployeeResponseDTO> getEmployeeById(@PathVariable int empNo) {
        Employee employee = this.employeeInteractor.getEmployeeById(empNo);
        EmployeeResponseDTO responseDTO = this.employeeDTOMapper.objectDoaminToResponseDTO(employee);
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByFirstName(@PathVariable String firstName) {
        List<Employee> employees = this.employeeInteractor.getEmployeeByFirstName(firstName);
        List<EmployeeResponseDTO> responseDTOs = employees.stream().map(this.employeeDTOMapper::objectDoaminToResponseDTO).toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/lastName/{lastName}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByLastName(@PathVariable String lastName) {
        List<Employee> employees = this.employeeInteractor.getEmployeeByLastName(lastName);
        List<EmployeeResponseDTO> responseDTOs = employees.stream().map(this.employeeDTOMapper::objectDoaminToResponseDTO).toList();
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/gender/{gender}")
    public ResponseEntity<List<EmployeeResponseDTO>> getEmployeeByGender(@PathVariable String gender) {
        List<Employee> employees = this.employeeInteractor.getEmployeeByGender(gender);
        List<EmployeeResponseDTO> responseDTOs = employees.stream().map(this.employeeDTOMapper::objectDoaminToResponseDTO).toList();
        return ResponseEntity.ok(responseDTOs);
    }
}
