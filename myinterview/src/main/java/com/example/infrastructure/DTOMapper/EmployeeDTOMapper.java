package com.example.infrastructure.DTOMapper;

import com.example.application.dto.EmployeeRequestDTO;
import com.example.application.dto.EmployeeResponseDTO;
import com.example.domain.entity.Employee;

public class EmployeeDTOMapper {

    public EmployeeRequestDTO objectDoaminToRequestDTO(Employee employee) {
        return new EmployeeRequestDTO(
                employee.getBirthDate().toString(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getHireDate().toString(),
                employee.getSalary()
        );
    }

    public EmployeeResponseDTO objectDoaminToResponseDTO(Employee employee) {
        return new EmployeeResponseDTO(
                employee.getEmpNo(),
                employee.getBirthDate().toString(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getGender(),
                employee.getHireDate().toString(),
                employee.getSalary()
        );
    }

    public Employee requestDTOToObjectDomain(EmployeeRequestDTO requestDTO) {
        return new Employee(requestDTO);
    }

    public Employee responseDTOToObjectDomain(EmployeeResponseDTO responseDTO) {
        return new Employee(responseDTO);
    }
}
