package com.digimart.DAO;

import java.util.List;

import com.digimart.entity.AdminEntity;
import com.digimart.entity.ForgotByEmail;
import com.digimart.entity.ForgotPassword;
import com.digimart.entity.Login;

public interface AdminDAO {

	public int addAdminProfile(AdminEntity adminEntity);
	public AdminEntity getByAdminId(int adminId);
	public int editAdminProfile(AdminEntity adminEntity);
	public List<Login> adminLogin(Login login);
	public List<AdminEntity> getByEmail(String emailID);
	public List<ForgotByEmail> checkEmailExist(ForgotByEmail byEmail);
	public int updatePassword(ForgotPassword forgotPassword);
	
}
