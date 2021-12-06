package edu.eci.cvds.sampleprj.dao;
import java.util.List;
import edu.eci.cvds.samples.entities.InvalidCategory;
import edu.eci.cvds.samples.services.SolidaridadException;

public interface InvalidCategoryDAO {

    List<InvalidCategory> load() throws SolidaridadException;
    InvalidCategory load(String word) throws SolidaridadException;
}