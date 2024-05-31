package com.example.infrastructure.gateways;

import com.example.application.gateways.EmployeeGateway;
import com.example.domain.entity.Employee;
import com.example.infrastructure.db.entitydb.EmployeeDB;
import com.example.infrastructure.repositories.EmployeeRepository;

import java.util.List;

public class EmployeeRepositoryGateway implements EmployeeGateway {

    private final EmployeeRepository repository;
    private  final EmployeeMapper employeeMapper;
    public EmployeeRepositoryGateway(
            EmployeeRepository employeeRepository,
            EmployeeMapper employeeMapper
    ) {
        this.repository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee createEmployee(Employee employeeDomain) {
        EmployeeDB employeeDB = this.employeeMapper.toEmployeeDB(employeeDomain);
        return this.employeeMapper.toEmployee(this.repository.save(employeeDB));
    }

    @Override
    public Employee updateEmployee(Employee employeeDomain) {
        EmployeeDB employeeDB = this.employeeMapper.toEmployeeDB(employeeDomain);
        return this.employeeMapper.toEmployee(this.repository.save(employeeDB));
    }

    @Override
    public void deleteEmployee(Employee employeeDomain) {
        this.repository.delete(this.employeeMapper.toEmployeeDB(employeeDomain));
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<EmployeeDB> list = this.repository.findAll();
        return list.stream().map(this.employeeMapper::toEmployee).toList();
    }

    @Override
    public Employee getEmployeeById(int empNo) {
        EmployeeDB employeeDB = this.repository.findByEmpNo(empNo);
        return this.employeeMapper.toEmployee(employeeDB);
    }

    @Override
    public List<Employee> getEmployeeByFirstName(String firstName) {
        List<EmployeeDB> list = this.repository.findByFirstName(firstName);
        return list.stream().map(this.employeeMapper::toEmployee).toList();
    }

    @Override
    public List<Employee> getEmployeeByLastName(String lastName) {
        List<EmployeeDB> list = this.repository.findByLastName(lastName);
        return list.stream().map(this.employeeMapper::toEmployee).toList();
    }

    @Override
    public List<Employee> getEmployeeByGender(String gender) {
        List<EmployeeDB> list = this.repository.findByGender(gender);
        return list.stream().map(this.employeeMapper::toEmployee).toList();
    }
}
