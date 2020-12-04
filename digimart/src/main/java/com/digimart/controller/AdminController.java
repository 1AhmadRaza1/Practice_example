package com.digimart.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.digimart.DAO.AdminDAO;
import com.digimart.entity.AdminEntity;
import com.digimart.entity.ForgotByEmail;
import com.digimart.entity.ForgotPassword;
import com.digimart.entity.Login;

@Controller
public class AdminController {
	
	@Autowired 
	private AdminDAO adminDao;

	@RequestMapping(value = "/")
	public ModelAndView dashboard() {
		return new ModelAndView("dashboard");
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public ModelAndView indexPage()
	{
		ModelAndView loginAdminModel=new ModelAndView("index");
		loginAdminModel.addObject("adminLogin", new Login());
		return loginAdminModel;
	}
	
	@RequestMapping(value="/new-admin-profile",method = RequestMethod.GET)
	public ModelAndView addAdminProfile()
	{
		ModelAndView addAdminModel=new ModelAndView("add_admin_profile");
		addAdminModel.addObject("addAdmin", new AdminEntity());
		return addAdminModel;
	}
	
	  @RequestMapping(value="/save-admin-profile",method = RequestMethod.POST)
	  public String save(@ModelAttribute("addAdmin") AdminEntity adminEntity){
		  adminDao.addAdminProfile(adminEntity); 
		  return "redirect:/login";
	  }
	  
	@RequestMapping(value="/update-admin-profile/{admin_id}",method = RequestMethod.GET)
	public ModelAndView editAdminProfile(@PathVariable int admin_id)
	{
		ModelAndView editAdminModel=new ModelAndView("edit_admin_profile");
		AdminEntity adminEntity=adminDao.getByAdminId(admin_id);
		editAdminModel.addObject("editprofile", adminEntity);
		return editAdminModel;
	}
	
	@RequestMapping(value="/edit-admin-profile",method = RequestMethod.POST)
	 public String updateProfile(@ModelAttribute("editprofile") AdminEntity adminEntity){
		adminDao.editAdminProfile(adminEntity); 
		return "redirect:/login";
	}
	
	@RequestMapping(value="/admin-detail",method = RequestMethod.POST)
	public ModelAndView LoginDetail(@ModelAttribute("adminLogin") Login login){
		ModelAndView andView=null; 
		List<Login> loginEmail=adminDao.adminLogin(login);
		if(loginEmail.isEmpty()) {
			andView=new ModelAndView("index");
			andView.addObject("msg", "invalid email and password .....");
		}else {
			String email=loginEmail.get(0).getAdmin_email();
			List<AdminEntity> adminList=adminDao.getByEmail(email);
			andView=new ModelAndView("admin_dashboard");
			andView.addObject("adminEmail", adminList);
		}
		return andView;
	}
	
	@RequestMapping(value="/forgot-by-email",method = RequestMethod.GET)
	public ModelAndView forgotPasswordByemail() {
		ModelAndView andView=new ModelAndView("forgot_pass_by_email");
		andView.addObject("forgetByEmail", new ForgotByEmail());
		return andView;
	}
	
	@RequestMapping(value="/check-emailid-exist",method = RequestMethod.POST)
	public ModelAndView checkEmail(@ModelAttribute("forgetByEmail") ForgotByEmail byEmail) {
		ModelAndView andView=null;
		List<ForgotByEmail> existemail=adminDao.checkEmailExist(byEmail);
		if(existemail.isEmpty()) {
			andView=new ModelAndView("forgot_pass_by_email");
			andView.addObject("msg", "Invalid email id");
		}else {
			andView=new ModelAndView("forgot_password");
			andView.addObject("forgotPassword", new ForgotPassword());
			andView.addObject("existEmail", existemail);
		}
		return andView;
	}
	
	@RequestMapping(value="/forgot-password",method = RequestMethod.POST)
	public String UpdateForgotPassword(@ModelAttribute("forgotPassword") ForgotPassword forgotPassword) {
		adminDao.updatePassword(forgotPassword);
		return "redirect:/login";
	}
}
