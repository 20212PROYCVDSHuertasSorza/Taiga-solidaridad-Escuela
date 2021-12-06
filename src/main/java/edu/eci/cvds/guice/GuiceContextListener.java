package edu.eci.cvds.guice;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.mybatis.guice.XMLMyBatisModule;
import org.mybatis.guice.datasource.helper.JdbcHelper;
import com.google.inject.Guice;
import com.google.inject.Injector;

import edu.eci.cvds.samples.services.*;
import  edu.eci.cvds.samples.services.impl.*;
import  edu.eci.cvds.security.*;
import  edu.eci.cvds.sampleprj.dao.mybatis.*;
import  edu.eci.cvds.sampleprj.dao.*;

import  edu.eci.cvds.security.*;


public class GuiceContextListener implements ServletContextListener  {

    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.removeAttribute(Injector.class.getName());
    }

    public void contextInitialized(ServletContextEvent servletContextEvent) {
		
        Injector injector = Guice.createInjector(new XMLMyBatisModule() {
			
            @Override
            protected void initialize() {

                install(JdbcHelper.PostgreSQL);
                setEnvironmentId("development");
                setClassPathResource("mybatis-config.xml");
				
				// //binding
                // //login
                bind(Log.class).to(ShiroLog.class);
                // //DAO

                bind(CategoryDAO.class).to(MyBatisCategoryDAO.class);
                bind(NeccesitiesDAO.class).to(MyBatisNeccesitiesDAO.class);
                bind(OffersDAO.class).to(MyBatisOffersDAO.class);
                bind(AnswersDAO.class).to(MyBatisAnswersDAO.class);
                bind(InvalidCategoryDAO.class).to(MyBatisInvalidCategoryDAO.class);
                bind(UserDAO.class).to(MyBatisUserDAO.class);
                
                // //Impl
                bind(CategoryService.class).to(CategoryServiceImpl.class);
                bind(NeccesitiesService.class).to(NeccesitiesServiceImpl.class);
                bind(OffersService.class).to(OffersServiceImpl.class);
                bind(AnswersService.class).to(AnswersServiceImpl.class);
                bind(InvalidCategoryService.class).to(InvalidCategoryServiceImpl.class);
                bind(UserService.class).to(UserServiceImpl.class);

            }
        });

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute(Injector.class.getName(), injector);
    }

}