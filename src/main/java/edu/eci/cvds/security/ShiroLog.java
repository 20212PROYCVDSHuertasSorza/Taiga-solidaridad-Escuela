
package edu.eci.cvds.security;

import edu.eci.cvds.samples.services.SolidaridadException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.subject.Subject;
import javax.faces.context.FacesContext;
import java.io.IOException;

public class ShiroLog implements Log {
    @Override
    public void login(String email, String password) throws SolidaridadException {
     
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(email, new Sha256Hash(password).toHex(),false);
            subject.getSession().setAttribute("email", email);
            subject.login(token);
        }
        catch (LockedAccountException lockedAccountException){
            throw new SolidaridadException("There have been too many attempts.",lockedAccountException);
        }
        catch (UnknownAccountException unknownAccountException){
            throw new SolidaridadException("Your account is not known.",unknownAccountException);
        }
        catch (IncorrectCredentialsException incorrectCredentialsException ){
            throw new SolidaridadException("Wrong credentials.",incorrectCredentialsException);
        }
        catch (AuthenticationException authenticationException){
            throw new SolidaridadException("Authentication error.",authenticationException);
        }
        catch( Exception exception){
            throw new SolidaridadException("Unexpected error!!!",exception);
        }
    }

    @Override
    public void logout()throws SolidaridadException {
        SecurityUtils.getSubject().logout();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/faces/login.xhtml");
        } catch (IOException ioException) {
            ioException.printStackTrace();
            throw new SolidaridadException("Unexpected error!!!",ioException);
        }
    }

    @Override
    public boolean isLogged() {
        return SecurityUtils.getSubject().isAuthenticated();
    }

}