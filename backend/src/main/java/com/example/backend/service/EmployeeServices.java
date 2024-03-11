package com.example.backend.service;


import com.example.backend.entity.Employee;

public interface EmployeeServices {

    public Employee addEmployee(Employee employee);
    public Employee updateEmployee(Employee employee);
    public void deleteEmployee(Long id);

}
