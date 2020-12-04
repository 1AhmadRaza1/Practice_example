package com.demoproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demoproject.entity.Student;
import com.demoproject.jsptag.JspClasses_1;
import com.demoproject.service.StudentService;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/")
	public ModelAndView home()
	{
		return new ModelAndView("home");
	}
	JspClasses_1 addJspTag=new JspClasses_1();
	@RequestMapping(value="/registration",method = RequestMethod.GET)
	public ModelAndView setUser()
	{
		System.out.println("call controller");
		ModelAndView modelAndView=new ModelAndView("addStudent");
		modelAndView.addObject("student", new Student());
		modelAndView.addObject("gender", addJspTag.gnder());
		return modelAndView;
	}
	
	@RequestMapping(value="/registration",method = RequestMethod.POST)
	public String addUser(@ModelAttribute Student student)
	{
		studentService.addStudent(student);
		return "redirect:/studentlist";
		
	}
	
	@RequestMapping(value="/editstudent/{stud_reg_id}",method =RequestMethod.GET)
	public ModelAndView editStudent(@PathVariable Integer stud_reg_id)
	{
		System.out.println(stud_reg_id);
		ModelAndView modelAndView=new  ModelAndView("editstudent");
		Student student=studentService.getStudent(stud_reg_id);
		modelAndView.addObject("student", student);
		modelAndView.addObject("gender", addJspTag.gnder());
		System.out.println("get by id  "+student);
		return  modelAndView;
	}
	@RequestMapping(value="/editstudent/{stud_reg_id}",method =RequestMethod.POST)
	public String updateStudent(@ModelAttribute Student student)
	{
		System.out.println("service  "+student);
		studentService.editStudent(student);
		return "redirect:/studentlist";
	}
	
	@RequestMapping(value="/lastadded",method = RequestMethod.POST)
	public String view(Model model,Student student)
	{
		model.addAttribute("student",student);
		return "view";
	}

	@RequestMapping(value="/studentlist")
	public ModelAndView listStudent()
	{
		ModelAndView modelAndView=new ModelAndView("studentList");
		List<Student> student=studentService.listOfStudent();
		System.out.println("return by sp    :   "+student);
		modelAndView.addObject("student", student);
		return modelAndView;
	}
	
	@RequestMapping(value="/deletestudent/{stud_reg_id}",method = RequestMethod.GET)
	public String deleteStudent(@PathVariable Integer stud_reg_id)
	{
		studentService.deleteStudent(stud_reg_id);
		return "redirect:/studentlist";
	}
}
