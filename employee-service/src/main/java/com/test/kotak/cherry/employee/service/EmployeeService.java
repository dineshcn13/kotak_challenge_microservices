package com.test.kotak.cherry.employee.service;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.kotak.cherry.employee.entity.Employee;
import com.test.kotak.cherry.employee.repository.EmployeeRepository;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    

    public Employee saveEmployee(Employee employee) {
        log.info("Inside saveEmployee of EmployeeService");
        return employeeRepository.save(employee);
    }


	public List<Employee> findEmployeeByCompanyId(Long companyId) {
		log.info("Inside findEmployeeByEmployeeId of EmployeeService");
		return employeeRepository.findEmployeeByCompanyId(companyId);
	}


}
