package edu.eci.cvds.security;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import edu.eci.cvds.view.LoginBean;

import org.apache.shiro.SecurityUtils;

public class UserNotAuthenticated extends AccessControlFilter {

    String welcomeurl;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); 

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (SecurityUtils.getSubject().hasRole("Administrador")) {
            welcomeurl="/faces/login.xhtml";
        } else if(SecurityUtils.getSubject().hasRole("Estudiante")){
            welcomeurl="/faces/login.xhtml";
        }else if(SecurityUtils.getSubject().hasRole("Profesor")){
            welcomeurl="/faces/login.xhtml";
        }
        else if(SecurityUtils.getSubject().hasRole("Egresado")){
            welcomeurl="/faces/login.xhtml";
        }
        else if(SecurityUtils.getSubject().hasRole("Administrativo")){
            welcomeurl="/faces/login.xhtml";
        }
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false;
    }

    public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }
}