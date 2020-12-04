package com.digimart.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.digimart.DAO.AdminDAO;
import com.digimart.DAO.AdminDAOImplimentation;
import com.digimart.DAO.ProductCategoryDAOImplimentation;
//import com.digimart.DAO.ProductCategoryDAOImplimentation;
//import com.digimart.DAO.ProductCategoryDao;
import com.digimart.DAO.ProductCategoryDao;

@Configuration
@ComponentScan("com.digimart.*")
@EnableWebMvc
public class WebConfiguration extends WebMvcConfigurerAdapter{

	@Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/digimart");
        dataSource.setUsername("root");
        dataSource.setPassword("@ahm@ad");
        return dataSource;
    }
	
	@Bean 
	  public UrlBasedViewResolver resolver() { 
		  UrlBasedViewResolver basedViewResolver=new UrlBasedViewResolver();
		  basedViewResolver.setPrefix("/WEB-INF/jsp/");
		  basedViewResolver.setSuffix(".jsp");
		  basedViewResolver.setViewClass(JstlView.class);
		  return basedViewResolver; 
	  }
	  
	  @Override 
	  public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/javascript/**")
		  .addResourceLocations("/WEB-INF/javascript/");
		  
		  registry.addResourceHandler("/css/**")
          .addResourceLocations("/WEB-INF/css/");
	  }
	  
	  @Bean
	  public AdminDAO getAdminDao() {
		  return new AdminDAOImplimentation(getDataSource());
	  }
	  
	  @Bean
	  public ProductCategoryDao getProductCategory() {
		  return new ProductCategoryDAOImplimentation(getDataSource());
	  }
	  
	  @Bean(name="multipartResolver")
		public CommonsMultipartResolver reslResolver()
		{
			CommonsMultipartResolver commonsMultipartResolver=new CommonsMultipartResolver();
			return commonsMultipartResolver;
		}
}
