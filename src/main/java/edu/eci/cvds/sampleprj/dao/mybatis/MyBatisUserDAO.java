package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.UserDAO;
import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.UserMapper;

import com.google.inject.Inject;
import edu.eci.cvds.samples.services.SolidaridadException;
import java.util.List;

public class MyBatisUserDAO implements UserDAO {
    @Inject
    private UserMapper UserMapper;

    @Override
    public List<User> load() throws SolidaridadException  {
        try{
            return UserMapper.searchUsers();
        }catch (Exception e){
            throw new SolidaridadException("Error. Looking for clients ",e);
        }
    }
    @Override
    public User load(String email) throws SolidaridadException {
        try{
            return UserMapper.searchUser(email);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Error. Username does not exist");
        }
    }

}