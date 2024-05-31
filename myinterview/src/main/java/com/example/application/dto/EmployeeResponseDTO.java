package com.example.application.dto;

import java.math.BigDecimal;

public record EmployeeResponseDTO(
        int emp_no,
        String birthDate,
        String firstName,
        String lastName,
        String gender,
        String hireDate,
        BigDecimal salary
) {
}
