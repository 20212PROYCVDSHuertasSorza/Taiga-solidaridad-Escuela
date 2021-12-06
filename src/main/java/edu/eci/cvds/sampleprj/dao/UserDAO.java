package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.User;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public interface UserDAO {

    List<User> load() throws SolidaridadException;

    User    load(String email) throws SolidaridadException;
    
}