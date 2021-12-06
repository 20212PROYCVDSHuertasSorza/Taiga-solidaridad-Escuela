package edu.eci.cvds.view;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import com.google.inject.Injector;

public abstract class BasePageBean implements Serializable {

  
    private Injector injector;

    public Injector getInjector() {
        System.out.println(injector);
        System.out.println("--------------");
        if (injector == null) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            
            injector = (Injector) servletContext.getAttribute(Injector.class.getName());
            System.out.println((Injector) servletContext.getAttribute(Injector.class.getName()) );
           
        }
        return injector;
    }

    public void setInjector(Injector injector) {
        this.injector = injector;
    }

    @PostConstruct
    public void init() {
        System.out.println(getInjector());
        getInjector().injectMembers(this);
    }
}