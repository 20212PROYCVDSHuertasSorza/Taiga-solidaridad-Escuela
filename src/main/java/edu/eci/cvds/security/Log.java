package edu.eci.cvds.security;

import edu.eci.cvds.samples.services.SolidaridadException;
public interface Log {
    /**
     * @param email, email of user
     * @param password, password of user
     */
    public void login(String email, String password) throws SolidaridadException;

    /**
     * logout
     */
    public void logout() throws SolidaridadException;

    /**
     * return status log
     */
    public boolean isLogged();
}