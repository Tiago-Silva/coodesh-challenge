package com.example.infrastructure.gateways;

import com.example.domain.entity.Employee;
import com.example.infrastructure.db.entitydb.EmployeeDB;

public class EmployeeMapper {

    EmployeeDB toEmployeeDB(Employee employee) {
        return new EmployeeDB(employee);
    }

    Employee toEmployee(EmployeeDB employeeDB) {
        return new Employee(employeeDB);
    }
}
