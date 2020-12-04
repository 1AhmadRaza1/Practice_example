package com.demoproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demoproject.DAO.StudentDAO;
import com.demoproject.entity.Student;
@Service
@Transactional
public class StudentServiceImplimentation implements StudentService{

	@Autowired
	StudentDAO studentDAO;
	@Override
	public void addStudent(Student student) {
		studentDAO.addStudent(student);
	}

	@Override
	public List<Student> listOfStudent() {
		// TODO Auto-generated method stub
		//System.out.println("retrn by sp.  " + studentDAO.listOfStudent());
		return studentDAO.listOfStudent();
		
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		return studentDAO.getStudent(id);
	}

	@Override
	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.editStudent(student);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteStudent(id);
		
	}

}
