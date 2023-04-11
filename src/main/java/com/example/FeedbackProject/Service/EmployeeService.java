package com.example.FeedbackProject.Service;

import com.example.FeedbackProject.Entity.Employee;
import com.example.FeedbackProject.Entity.SearchBarResult;
import com.example.FeedbackProject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee emp){
        Employee employee=this.employeeRepository.save(emp);
        return employee;
    }

    public Employee updateEmployee(Employee emp, String id){

        Employee empl=this.employeeRepository.findById(id).map(employee -> {
            employee.setName(emp.getName());
            employee.setPass(emp.getPass());
            employee.setManagerId(emp.getManagerId());
            employee.setUType(emp.getUType());
            return this.employeeRepository.save(emp);
        }).orElseThrow();
        return empl;
    }

    public Optional<Employee> getEmpByName(String name) {
        return employeeRepository.findByName(name);
    }

    public List<Object[]> getEmp(String var){
        List<Object[]> searchResults = employeeRepository.getEmpByName(var);
        return searchResults;
    }
}
