package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.User;

import java.util.List;

public interface UserService {

    public abstract List<User> searchUser() throws SolidaridadException;

    User searchUser(String email) throws SolidaridadException;

}