package com.test.kotak.cherry.company.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.test.kotak.cherry.company.responsedata.Employee;

@FeignClient(name="EMPLOYEE-SERVICE")
public interface EmployeeServiceProxy {
	
	@GetMapping("employees/")
	String getEmployeeCall();
	
	@GetMapping("employees/{id}")
	List<Employee> findEmployeeByCompanyId(@PathVariable("id") Long companyId);
}
