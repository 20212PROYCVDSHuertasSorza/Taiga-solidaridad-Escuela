package edu.eci.cvds.sampleprj.dao;

import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;

import java.util.List;

public interface CategoryDAO {
    void save(Category category) throws SolidaridadException;

    void delete(String name, int idCategory) throws SolidaridadException;

    List<Category> load() throws SolidaridadException;

    void update(Category categoryName, String name, String description, String state) throws SolidaridadException, PSQLException;

    Category load(String name) throws SolidaridadException;
    public List<Category> searchNumberCategory( String category) throws SolidaridadException;
    
}