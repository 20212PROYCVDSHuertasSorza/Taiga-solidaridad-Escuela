package edu.eci.cvds.sampleprj.dao;
import java.util.List;
import edu.eci.cvds.samples.entities.Answers;
import edu.eci.cvds.samples.services.SolidaridadException;


public interface AnswersDAO {

    
    void save(Answers Answers) throws SolidaridadException;

    List<Answers> load() throws SolidaridadException;

    Answers load(String name) throws SolidaridadException;

}