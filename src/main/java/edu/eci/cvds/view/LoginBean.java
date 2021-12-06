package edu.eci.cvds.view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import com.google.inject.Inject;
import javax.servlet.http.HttpSession;
import edu.eci.cvds.security.Log;
import edu.eci.cvds.samples.services.SolidaridadException;


@SuppressWarnings("deprecation")
@ManagedBean(name = "login")
@SessionScoped
public class LoginBean extends BasePageBean{
    @Inject
    private Log log;
    private String email;
    private String password;
    private Subject currentUser;

     private FacesMessage.Severity state;
    private String message;

     public void loginUser() {
        try{
            currentUser = SecurityUtils.getSubject();
            logCorrect();
            
            currentUser = SecurityUtils.getSubject();
             
             System.out.println( SecurityUtils.getSubject().isAuthenticated());
             
             if (log.isLogged()) {
             System.out.println("Is logged now**********************");
                 throw new SolidaridadException("Is logged now");
             }
             else {
                System.out.println(" Is logging***********************");
                log.login(email, password);
                System.out.println(" redirection************************");
                redireccion();
             }
        }
        catch( Exception exception){
            message = exception.getMessage();
            state = FacesMessage.SEVERITY_WARN;
            System.out.println(exception);
             System.out.println(" Error Message!");
             System.out.println(message);
             System.out.println(" Error Message!");
             System.out.println(estado);
             System.out.println(" Error Message!");
            restartInput();
        }
         
    }
    public void loginState() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(state, "LogIn", message));
    }
    public void restartInput(){
        password = "";
        email = "";
    }
     public void logCorrecto(){
        message ="Login completed";
        state = FacesMessage.SEVERITY_INFO;
    }

    public void redireccion() {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("email", email);
          
            if(currentUser.hasRole("Administrador")){
                System.out.println("redirection finshed administrador");
                facesContext.getExternalContext().redirect("/faces/homeAdministrador.xhtml");
            }
            if(currentUser.hasRole("Estudiante")){
                System.out.println("redirection finshed administrador");
                facesContext.getExternalContext().redirect("/faces/index.html");
            }
            if(currentUser.hasRole("Profesor")){
                System.out.println("redirection finshed administrador");
                facesContext.getExternalContext().redirect("/faces/index.html");
            }
            if(currentUser.hasRole("Egresado")){
                System.out.println("redirection finshed administrador");
                facesContext.getExternalContext().redirect("/faces/index.html");
            }
            if(currentUser.hasRole("Administrativo")){
                System.out.println("redirection finshed administrador");
                facesContext.getExternalContext().redirect("/faces/index.html");
            }
            System.out.println("redirection finshed");
        
                
        }
        catch (Exception exception) {
            System.out.println("excepcion redirection");
            System.out.println(exception.getMessage());
            logOut();
        }
    }
    public void logOut(){
        try{
            log.logout();
            restartInput();
        }
        catch(Exception exception){
        }
    }

    public String getEmail() {
        return email;
    }
   

    /**
     * set user email 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get user
     * @param password, represents user password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Method  to get user password
     * @return String
     */
    public String getPassword() {
        return password;
    }
}