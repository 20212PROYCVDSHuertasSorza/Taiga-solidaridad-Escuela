package edu.eci.cvds.samples.services;

import com.google.inject.Injector;

import edu.eci.cvds.sampleprj.dao.*;
import edu.eci.cvds.sampleprj.dao.mybatis.*;
import edu.eci.cvds.samples.services.impl.*;

import org.mybatis.guice.XMLMyBatisModule;
import java.util.Optional;

import static com.google.inject.Guice.createInjector;



public class SolidaridadFactory {
    private static final SolidaridadFactory instance = new SolidaridadFactory();
    private static Optional<Injector> optionalInjector;

    private Injector myBatisInjector(String env, String pathResource){
        return createInjector(new XMLMyBatisModule(){

            @Override
            protected void initialize() {
                setEnvironmentId(env);
                setClassPathResource(pathResource);

                bind(CategoryService.class).to(CategoryServiceImpl.class);
                bind(CategoryDAO.class).to(MyBatisCategoryDAO.class);

                bind(AnswersService.class).to(AnswersServiceImpl.class);
                bind(AnswersDAO.class).to(MyBatisAnswersDAO.class);
                
                bind(NeccesitiesService.class).to(NeccesitiesServiceImpl.class);
                bind(NeccesitiesDAO.class).to(MyBatisNeccesitiesDAO.class);

                bind(OffersService.class).to(OffersServiceImpl.class);
                bind(OffersDAO.class).to(MyBatisOffersDAO.class);

                bind(InvalidCategoryService.class).to(InvalidCategoryServiceImpl.class);
                bind(InvalidCategoryDAO.class).to(MyBatisInvalidCategoryDAO.class);

                bind(UserDAO.class).to(MyBatisUserDAO.class);
                bind(UserService.class).to(UserServiceImpl.class);
            }
        });
    }

    private SolidaridadFactory() { optionalInjector = Optional.empty();}


    public AnswersService getAnswersService(){
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(AnswersService.class);
    }
    
    public NeccesitiesService getNeccesitiesService(){
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(NeccesitiesService.class);
    }
    public CategoryService getCategoryService(){
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(CategoryService.class);
    }
    public OffersService getOffersService(){
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(OffersService.class);
    }

    public UserService getUserService(){
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(UserService.class);
    }

    public InvalidCategoryService getInvalidCategoryService() {
        if(!optionalInjector.isPresent()){
            optionalInjector = Optional.of(myBatisInjector("development","mybatis-config.xml"));
        }
        return optionalInjector.get().getInstance(InvalidCategoryService.class);
    }
    public static SolidaridadFactory getInstance(){ return instance; }
}
