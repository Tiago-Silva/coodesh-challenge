package com.example.domain.entity;


import com.example.application.dto.EmployeeRequestDTO;
import com.example.application.dto.EmployeeResponseDTO;
import com.example.infrastructure.db.entitydb.EmployeeDB;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "empNo")
public class Employee implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int empNo;

    private Date birthDate;

    private String firstName;

    private String lastName;

    private String gender;

    private Date hireDate;

    private BigDecimal salary;

    public Employee(EmployeeDB employeeDB) {
        this.empNo = employeeDB.getEmpNo();
        this.birthDate = employeeDB.getBirthDate();
        this.firstName = employeeDB.getFirstName();;
        this.lastName = employeeDB.getLastName();
        this.gender = employeeDB.getGender();
        this.hireDate = employeeDB.getHireDate();
        this.salary = employeeDB.getSalary();
    }

    public Employee(EmployeeRequestDTO requestDTO) {
        this.birthDate = this.parseDate(requestDTO.birthDate());
        this.firstName = requestDTO.firstName();
        this.lastName = requestDTO.lastName();
        this.gender = requestDTO.gender();
        this.hireDate = this.parseDate(requestDTO.hireDate());
        this.salary = requestDTO.salary();
    }

    public Employee(EmployeeResponseDTO responseDTO) {
        this.empNo = responseDTO.emp_no();
        this.birthDate = this.parseDate(responseDTO.birthDate());
        this.firstName = responseDTO.firstName();
        this.lastName = responseDTO.lastName();
        this.gender = responseDTO.gender();
        this.hireDate = this.parseDate(responseDTO.hireDate());
        this.salary = responseDTO.salary();
    }

    private Date parseDate(String date) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.parse(date);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
