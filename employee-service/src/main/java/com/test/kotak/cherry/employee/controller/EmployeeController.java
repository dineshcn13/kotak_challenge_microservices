package com.test.kotak.cherry.employee.controller;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.kotak.cherry.employee.entity.Employee;
import com.test.kotak.cherry.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public Employee saveEmployee(@RequestBody Employee employee) {
        log.info("Inside saveEmployee of EmployeeController");
        return employeeService.saveEmployee(employee);
    }
    
    @GetMapping("/")
    public String getEmployeeCall() {
        log.info("Inside getEmployeeCall of EmployeeController");
        return "Hello World of Employee Controller!";
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<List<Employee>> findEmployeeByCompanyId(@PathVariable("id") Long companyId) {
        log.info("Inside findEmployeeByEmployeeId method of EmployeeController");
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.findEmployeeByCompanyId(companyId));
    }


}
