package com.test.kotak.cherry.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.kotak.cherry.employee.entity.Employee;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Long> {

	List<Employee> findEmployeeByCompanyId(Long companyId);
}
