package com.example.application.usecases;

import com.example.application.gateways.EmployeeGateway;
import com.example.domain.entity.Employee;

import java.util.List;

public class EmployeeInteractor {

    private final EmployeeGateway employeeGateway;
    public EmployeeInteractor(EmployeeGateway employeeGateway) {
        this.employeeGateway = employeeGateway;
    }

    public Employee createEmployee(Employee employee) {
        return this.employeeGateway.createEmployee(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return this.employeeGateway.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        this.employeeGateway.deleteEmployee(employee);
    }

    public List<Employee> getAllEmployees() {
        return this.employeeGateway.getAllEmployees();
    }

    public Employee getEmployeeById(int empNo) {
        return this.employeeGateway.getEmployeeById(empNo);
    }

    public List<Employee> getEmployeeByFirstName(String firstName) {
        return this.employeeGateway.getEmployeeByFirstName(firstName);
    }

    public List<Employee> getEmployeeByLastName(String lastName) {
        return this.employeeGateway.getEmployeeByLastName(lastName);
    }

    public List<Employee> getEmployeeByGender(String gender) {
        return this.employeeGateway.getEmployeeByGender(gender);
    }
}
