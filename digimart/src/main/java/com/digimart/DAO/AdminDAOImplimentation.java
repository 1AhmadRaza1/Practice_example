package com.digimart.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.digimart.entity.AdminEntity;
import com.digimart.entity.ForgotByEmail;
import com.digimart.entity.ForgotPassword;
import com.digimart.entity.Login;

public class AdminDAOImplimentation implements AdminDAO{

	
	private JdbcTemplate template;
	private String sql="";
	public AdminDAOImplimentation(DataSource dataSource) {
		template=new JdbcTemplate(dataSource);
	}
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}    
	
	@Override
	public int addAdminProfile(AdminEntity adminEntity) {
		sql="insert into admin(admin_name,admin_mobile,admin_email,admin_password)values('"+adminEntity.getAdmin_name()+"','"+adminEntity.getAdmin_mobile()+"','"+adminEntity.getAdmin_email()+"','"+adminEntity.getAdmin_password()+"')";    
		return template.update(sql);
	}

	@Override
	public int editAdminProfile(AdminEntity adminEntity) {
		sql="update admin set admin_name='"+adminEntity.getAdmin_name()+"',admin_mobile='"+adminEntity.getAdmin_mobile()+"',admin_email='"+adminEntity.getAdmin_email()+"',admin_password='"+adminEntity.getAdmin_password()+"' where admin_id="+adminEntity.getAdmin_id()+" ";
		return template.update(sql);
	}
	
	@Override
	public List<Login> adminLogin(Login login) {
		sql="select * from admin where admin_email='"+login.getAdmin_email()+"' and admin_password='"+login.getAdmin_password()+"' ";
		return template.query(sql,new RowMapper<Login>() {
			public Login mapRow(ResultSet rs,int row) throws SQLException{
				Login login=new Login();
				login.setAdmin_email(rs.getString("admin_email"));
				//login.setAdmin_password(rs.getString("admin_password"));
				return login;
			}
		});
	}

	@Override
	public AdminEntity getByAdminId(int adminId) {
		sql="select * from admin where admin_id=?";
		return template.queryForObject(sql, new Object[]{adminId},new BeanPropertyRowMapper<AdminEntity>(AdminEntity.class));
	}

	@Override
	public List<AdminEntity> getByEmail(String emailId) {
		sql="select * from admin where admin_email='"+emailId+"' ";
		return template.query(sql,new RowMapper<AdminEntity>() {
			public AdminEntity mapRow(ResultSet rs,int row) throws SQLException{
				AdminEntity getAdminEntity=new AdminEntity();
				getAdminEntity.setAdmin_id(rs.getInt("admin_id"));
				getAdminEntity.setAdmin_name(rs.getString("admin_name"));
				getAdminEntity.setAdmin_mobile(rs.getString("admin_mobile"));
				getAdminEntity.setAdmin_email(rs.getString("admin_email"));
				getAdminEntity.setAdmin_password(rs.getString("admin_password"));
				return getAdminEntity;
			}
		});
	
	}

	@Override
	public List<ForgotByEmail> checkEmailExist(ForgotByEmail byEmail) {
		sql="select * from admin where admin_email='"+byEmail.getAdmin_email()+"' ";
		return template.query(sql,new RowMapper<ForgotByEmail>() {
			public ForgotByEmail mapRow(ResultSet rs,int row) throws SQLException{
				ForgotByEmail existEmail=new ForgotByEmail();
				existEmail.setAdmin_email(rs.getString("admin_email"));
				return existEmail;
			}
		});
	}

	@Override
	public int updatePassword(ForgotPassword forgotPassword) {
		sql="update admin set admin_password='"+forgotPassword.getAdmin_password()+"' where admin_email='"+forgotPassword.getAdmin_email()+"' ";
		return template.update(sql);
	}
}
