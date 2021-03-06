package com.demoproject.service;

import java.util.List;
import com.demoproject.entity.Student;

public interface StudentService {
	public void addStudent(Student student);
	public List<Student> listOfStudent();
	public Student getStudent(int id);
	public void editStudent(Student student);
	public void deleteStudent(int id);
}
