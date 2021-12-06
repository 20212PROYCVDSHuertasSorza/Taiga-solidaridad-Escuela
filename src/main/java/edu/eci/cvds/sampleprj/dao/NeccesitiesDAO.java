package edu.eci.cvds.sampleprj.dao;
import java.util.List;
import edu.eci.cvds.samples.entities.Neccesities;
import edu.eci.cvds.samples.services.SolidaridadException;

public interface NeccesitiesDAO {

    void save(Neccesities Neccesities) throws SolidaridadException;

    List<Neccesities> load() throws SolidaridadException;

    void update(String nameNeccesities,String state) throws SolidaridadException;

    Neccesities load(String name) throws SolidaridadException;
    public List<Neccesities> searchNumberNeccesitiesState( String state) throws SolidaridadException;
}