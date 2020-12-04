package com.demoproject.Configuration;

import java.util.Properties;

import javax.annotation.Resource;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.demoproject.*")
@PropertySource("classpath:dbproperty.properties")
public class WebConfiguration {
	  
	private static final String DRIVER="db.driver";
	private static final String URL="db.url";
	private static final String USER_NAME="db.username";
	private static final String PASSWORD="db.password";
	private static final String DIALECT="db.dialect";
	private static final String TO_SCAN="org.package.to_scan";
	private static final String SHOW_SQL="db.showSql";
	@Resource
	Environment envoirnment;
	@Bean
	public DataSource source()
	{
		DriverManagerDataSource managerDataSource=new DriverManagerDataSource();
		managerDataSource.setDriverClassName(envoirnment.getRequiredProperty(DRIVER));
		managerDataSource.setUrl(envoirnment.getRequiredProperty(URL));
		managerDataSource.setUsername(envoirnment.getRequiredProperty(USER_NAME));
		managerDataSource.setPassword(envoirnment.getRequiredProperty(PASSWORD));
		return managerDataSource;
	}
	
	@Bean
	public Properties properties()
	{
		Properties properties=new Properties();
		properties.setProperty(DIALECT, envoirnment.getRequiredProperty(DIALECT));
		properties.setProperty(SHOW_SQL, envoirnment.getRequiredProperty(SHOW_SQL));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean factorybean()
	{
		LocalSessionFactoryBean localSessionFactoryBean=new LocalSessionFactoryBean();
		localSessionFactoryBean.setPackagesToScan(envoirnment.getRequiredProperty(TO_SCAN));
		localSessionFactoryBean.setDataSource(source());
		localSessionFactoryBean.setHibernateProperties(properties());
		return localSessionFactoryBean;
	}
	
	@Bean
	public HibernateTransactionManager htmanager()
	{
		HibernateTransactionManager hibernateTransactionManager=new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(factorybean().getObject());
		return hibernateTransactionManager;
	}
	
	@Bean
	public UrlBasedViewResolver resolver() {
		UrlBasedViewResolver basedViewResolver=new UrlBasedViewResolver();
		basedViewResolver.setPrefix("/WEB-INF/JspPages/");
		basedViewResolver.setSuffix(".jsp");
		basedViewResolver.setViewClass(JstlView.class);
		return basedViewResolver;
	  }
}
