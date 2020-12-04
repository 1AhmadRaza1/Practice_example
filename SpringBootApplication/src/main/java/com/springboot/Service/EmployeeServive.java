package com.springboot.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.Entity.EmployeeEntity;
import com.springboot.Repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServive {

	@Autowired
	EmployeeRepository employeeRepository;
	public EmployeeEntity addEmployee(EmployeeEntity employeeEntity)
	{
		System.out.println("services   :   "+employeeEntity.getName());
		return employeeRepository.save(employeeEntity);
	}
}
