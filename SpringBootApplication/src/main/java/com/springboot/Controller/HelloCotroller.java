package com.springboot.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.Entity.EmployeeEntity;
import com.springboot.Service.EmployeeServive;

@RestController
@RequestMapping("/spring-boot")
public class HelloCotroller {

	@RequestMapping("/hello-world")
	public String helloWprld() {
		System.out.println("how  r u");
		return "Hello ahmad raza";
	}
	@Autowired
	private EmployeeServive employeeServive;
	
	@PostMapping(value="/new-employee")
	public String newEmployee(@RequestBody EmployeeEntity employeeEntity) {
		System.out.println("jjjjjjjjjjj :  "+employeeEntity.getName());
		employeeServive.addEmployee(employeeEntity); 
		return "hi"+ employeeEntity.getName() +"Inserted Sucessfully";
	}
}
