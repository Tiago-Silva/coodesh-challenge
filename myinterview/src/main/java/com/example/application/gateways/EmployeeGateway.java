package com.example.application.gateways;

import com.example.domain.entity.Employee;

import java.util.List;

public interface EmployeeGateway {

    Employee createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Employee getEmployeeById(int empNo);
    List<Employee> getEmployeeByFirstName(String firstName);
    List<Employee> getEmployeeByLastName(String lastName);
    List<Employee> getEmployeeByGender(String gender);
}
