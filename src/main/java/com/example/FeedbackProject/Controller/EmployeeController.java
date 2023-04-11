package com.example.FeedbackProject.Controller;

import com.example.FeedbackProject.Entity.Employee;
import com.example.FeedbackProject.Entity.SearchBarResult;
import com.example.FeedbackProject.Repository.EmployeeRepository;
import com.example.FeedbackProject.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployeeByAdmin(@RequestBody Employee emp){
        Employee employee=this.employeeService.createEmployee(emp);
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp,@PathVariable String id){
        Employee employee=this.employeeService.updateEmployee(emp,id);
        return new ResponseEntity<>(employee,HttpStatus.CREATED);
    }

    @GetMapping("/{name}")
    public Optional<Employee> getEmpByName(@PathVariable String name){
        return employeeService.getEmpByName(name);
    }

    @GetMapping("/Emp")
    public List<Object[]> getAllEmployee(@RequestParam("var") String var)
    {
        return employeeService.getEmp(var);
    }
}

