package com.example.application.dto;

import java.math.BigDecimal;

public record EmployeeRequestDTO(
        String birthDate,
        String firstName,
        String lastName,
        String gender,
        String hireDate,
        BigDecimal salary
) {
}
