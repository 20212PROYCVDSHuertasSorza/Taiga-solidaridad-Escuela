package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.Neccesities;

import java.util.List;

public interface NeccesitiesService {
    public abstract void pushNeccesities(Neccesities neccesities) throws SolidaridadException;

    public abstract List<Neccesities> searchNeccesities() throws SolidaridadException;

    public abstract void updateNeccesities(String neccesitiesName, String state) throws SolidaridadException;

    Neccesities searchNeccesities(String name)throws SolidaridadException;
    
    int searchNumberNeccesitiesState(String state);
}