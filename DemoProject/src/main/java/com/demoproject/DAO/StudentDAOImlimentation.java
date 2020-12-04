package com.demoproject.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demoproject.dbconnection.DBConnection;
import com.demoproject.entity.Student;
@Repository
public class StudentDAOImlimentation implements StudentDAO{

	@Autowired
	private SessionFactory sessionfactory;
	public Session getCurrentSession()
	{
		return sessionfactory.getCurrentSession();
	}
	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		System.out.println(student);
		getCurrentSession().save(student);
	}

	@Override
	public List<Student> listOfStudent() {
		// TODO Auto-generated method stub
		//return getCurrentSession().createQuery("from Student").list();
		return getCurrentSession().getNamedQuery("getStudentList").list();
	}

	@Override
	public Student getStudent(int id) {
		// TODO Auto-generated method stub
		Student student= (Student)getCurrentSession().get(Student.class, id);
		return student;
	}

	@Override
	public void editStudent(Student student) {
		// TODO Auto-generated method stub
		Student studentUpdate=getStudent(student.getStud_reg_id());
		studentUpdate.setStud_name(student.getStud_name());
		studentUpdate.setGender(student.getGender());
		studentUpdate.setDob(student.getDob());
		studentUpdate.setEmail(student.getEmail());
		studentUpdate.setPassword(student.getPassword());
		studentUpdate.setMobileno(student.getMobileno());
		System.out.println(studentUpdate);
		getCurrentSession().saveOrUpdate(studentUpdate);
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		Student student=(Student)getCurrentSession().get(Student.class, id);
		
		getCurrentSession().delete(student);
	}

}
