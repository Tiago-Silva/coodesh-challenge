package com.example.infrastructure.repositories;

import com.example.infrastructure.db.entitydb.EmployeeDB;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<EmployeeDB, Integer> {

    EmployeeDB findByEmpNo(int empNo);
    List<EmployeeDB> findByFirstName(String first_name);
    List<EmployeeDB> findByLastName(String last_name);
    List<EmployeeDB> findByGender(String gender);
}
