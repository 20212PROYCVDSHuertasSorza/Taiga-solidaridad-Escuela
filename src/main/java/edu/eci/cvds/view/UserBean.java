package edu.eci.cvds.view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;
import edu.eci.cvds.samples.services.SolidaridadFactory;


import java.sql.Date;
import java.util.List;

@ManagedBean(name = "UserBean")
@ApplicationScoped
public class UserBean extends BasePageBean{
    @Inject
    private UserService userService;


 
    public User searchUser(String email) throws SolidaridadException{
        try{
            return userService.searchUser(email);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The user don't exist");
        }
    }

    public List<User> searchUsers() throws SolidaridadException{
        try{
            return userService.searchUsers();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the users in UsuariosBean");
        }
    }

 
    
}