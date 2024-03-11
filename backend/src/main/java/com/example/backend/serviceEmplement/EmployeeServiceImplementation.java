package com.example.backend.serviceEmplement;
import com.example.backend.exception.UserNotFoundException;
import com.example.backend.entity.Employee;
import com.example.backend.repository.EmployeeRepository;
import com.example.backend.service.EmployeeServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class EmployeeServiceImplementation implements EmployeeServices {
private final EmployeeRepository employeeRepository;
@Autowired
    public EmployeeServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee){
    employee.setAccountNumber(UUID.randomUUID().toString());
    return employeeRepository.save(employee);
    }


    public List<Employee>findAllEmployee(){
    return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee){
    return employeeRepository.save(employee);
    }


    public Employee findEmployeeById(Long id){
    return employeeRepository.findEmployeeById(id)
            .orElseThrow(()-> new UserNotFoundException("User by id was not found"));
    }
    @Transactional
    public void deleteEmployee(Long id){
    employeeRepository.deleteEmployeeById(id);
    }




}
