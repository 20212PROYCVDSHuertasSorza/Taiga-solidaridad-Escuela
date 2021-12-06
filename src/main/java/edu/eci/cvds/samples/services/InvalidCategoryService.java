package edu.eci.cvds.samples.services;

import edu.eci.cvds.samples.entities.InvalidCategory;
import java.util.List;

public interface InvalidCategoryService {
    public abstract List<InvalidCategory> searchInvalidCategory() throws SolidaridadException;

    InvalidCategory searchInvalidCategory(String word) throws SolidaridadException;

}