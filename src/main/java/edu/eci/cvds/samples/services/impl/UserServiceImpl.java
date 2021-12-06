package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.UserDAO;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.services.UserService;
import edu.eci.cvds.samples.services.SolidaridadException;
import javax.transaction.Transactional;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Inject
    private UserDAO UserDAO;

    
    @Override
    public List<User> searchUser() throws SolidaridadException {
        try{
            return UserDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("Error. not found client");
        }
    }

    @Override
    public User searchUser(String email) throws SolidaridadException {
        try{
            return UserDAO.load(email);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("User "+email+" does not exist");
        }
    }
}