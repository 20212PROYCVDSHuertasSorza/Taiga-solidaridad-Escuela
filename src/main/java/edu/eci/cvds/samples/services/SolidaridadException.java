package edu.eci.cvds.samples.services;

public class SolidaridadException extends Exception {
    
    public static final String INCORRECT_USER = "The user is incorrect";
    
    public static final String INCORRECT_PASSWORD = "The password is invalid";

    public SolidaridadException() {
    }

    public SolidaridadException(String message) {
        super(message);
    }

     public SolidaridadException(String message, Exception Exception) {
         super(message, Exception);
     }

    
    
}