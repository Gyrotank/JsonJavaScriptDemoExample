package com.howtodoinjava.demo.controller;
 
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
 


import com.howtodoinjava.demo.model.EmployeeListVO;
import com.howtodoinjava.demo.model.EmployeeVO;
 
@RestController
public class EmployeeRESTController 
{
	EmployeeListVO employees;
	
	private void setUpData() {
		employees = new EmployeeListVO();
		
		EmployeeVO empOne = new EmployeeVO(1,"Lokesh","Gupta","howtodoinjava@gmail.com");
	    EmployeeVO empTwo = new EmployeeVO(2,"Amit","Singhal","asinghal@yahoo.com");
	    EmployeeVO empThree = new EmployeeVO(3,"Kirti","Mishra","kmishra@gmail.com");
	    
	    employees.getEmployees().add(empOne);
	    employees.getEmployees().add(empTwo);
	    employees.getEmployees().add(empThree);
	}    
    
    @RequestMapping(value = "/employees")
    public @ResponseBody List<EmployeeVO> getAllEmployees() 
    {   
    	setUpData();
    	
        return employees.getEmployees();
    }
     
    @RequestMapping(value = "/employees/{id}")
    @ResponseBody
    public ResponseEntity<EmployeeVO> getEmployeeById (@PathVariable("id") int id) 
    {
    	setUpData();
    	
    	EmployeeVO res = employees.getEmployeeById(id);
    	
        if (res != null) {
            return new ResponseEntity<EmployeeVO>(res, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}