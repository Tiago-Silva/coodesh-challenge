package com.example.infrastructure.db.entitydb;


import com.example.domain.entity.Employee;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "result_test_guilherme")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "empNo")
public class EmployeeDB implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private int empNo;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "hire_date")
    private Date hireDate;

    private BigDecimal salary;

    public EmployeeDB(Employee employee) {
        this.empNo = employee.getEmpNo();
        this.birthDate = employee.getBirthDate();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.gender = employee.getGender();
        this.hireDate = employee.getHireDate();
        this.salary = employee.getSalary();
    }
}
