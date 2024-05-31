package com.example.infrastructure.config;

import com.example.application.gateways.EmployeeGateway;
import com.example.application.usecases.EmployeeInteractor;
import com.example.infrastructure.DTOMapper.EmployeeDTOMapper;
import com.example.infrastructure.gateways.EmployeeMapper;
import com.example.infrastructure.gateways.EmployeeRepositoryGateway;
import com.example.infrastructure.repositories.EmployeeRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    EmployeeInteractor employeeInteractor(EmployeeGateway employeeGateway) {
        return new EmployeeInteractor(employeeGateway);
    }

    @Bean
    EmployeeGateway employeeGateway(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        return new EmployeeRepositoryGateway(employeeRepository, employeeMapper);
    }

    @Bean
    EmployeeMapper employeeMapper() {
        return new EmployeeMapper();
    }

    @Bean
    EmployeeDTOMapper employeeDTOMapper() {
        return new EmployeeDTOMapper();
    }
}
