package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.InvalidCategoryDAO;
import edu.eci.cvds.samples.entities.InvalidCategory;
import edu.eci.cvds.samples.services.InvalidCategoryService;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;


public class InvalidCategoryServiceImpl implements InvalidCategoryService{

    @Inject
    private InvalidCategoryDAO InvalidCategoryDAO;

    @Override
    public List<InvalidCategory> searchInvalidCategory() throws SolidaridadException {
        try{
            return InvalidCategoryDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("not found invalid category");
        }
    }

    @Override
    public InvalidCategory searchInvalidCategory(String word) throws SolidaridadException {
        try{
            return InvalidCategoryDAO.load(word);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("the invalid category "+word+" doesnt exist");
        }
    }
}