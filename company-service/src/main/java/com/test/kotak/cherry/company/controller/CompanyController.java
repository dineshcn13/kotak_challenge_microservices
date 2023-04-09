package com.test.kotak.cherry.company.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import com.test.kotak.cherry.company.entity.Company;
import com.test.kotak.cherry.company.responsedata.ResponseData;
import com.test.kotak.cherry.company.service.CompanyService;

@RestController
@RequestMapping("/companies")
@Slf4j
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/")
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        log.info("Inside saveCompany method of CompanyController");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.saveCompany(company));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> findCompanyByCompanyId(@PathVariable("id") Long companyId) {
        log.info("Inside findCompanyByCompanyId method of CompanyController");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompanyByCompanyId(companyId));
    }
    
    @GetMapping("/f/{id}")
    public ResponseEntity<ResponseData> getEmployeeWithCompany(@PathVariable("id") Long companyId) {
        log.info("Inside getEmployeeWithCompany method of CompanyController");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getEmployeeWithCompany(companyId));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyByCompanyId(@PathVariable("id") Long companyId) {
        log.info("Inside deleteCompanyByCompanyId method of CompanyController");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.deleteCompanyByCompanyId(companyId));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompanyByCompanyId(@RequestBody Company company,@PathVariable("id") Long companyId){
    	
    	log.info("Inside updateCompanyByCompanyId method of CompanyController");
    	
    	Company company1 = companyService.findCompanyByCompanyId(companyId);
    	
    	if(ObjectUtils.isEmpty(company1)) {
    		
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(companyService.updateCompanyByCompanyId(company1));
    		
    	} else {
    	
	    	company1.setCompanyAddress(company.getCompanyAddress());
	    	company1.setCompanyCode(company.getCompanyCode());
	    	company1.setCompanyName(company.getCompanyName());
	    	
	    	return ResponseEntity.status(HttpStatus.OK).body(companyService.updateCompanyByCompanyId(company1));
    	}
    	
    }
    
    @GetMapping("/hello")
    public ResponseEntity<String> getHelloWorld() {
        log.info("Inside getHelloWorld method of CompanyController");
        return ResponseEntity.status(HttpStatus.OK).body(companyService.getHelloWorld());
    }

}
