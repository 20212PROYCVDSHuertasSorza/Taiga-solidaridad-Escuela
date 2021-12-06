package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.InvalidCategoryDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.InvalidCategoryMapper;
import edu.eci.cvds.samples.entities.InvalidCategory;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public class MyBatisInvalidCategoryDAO implements InvalidCategoryDAO{
    @Inject
    private InvalidCategoryMapper invalidCategoryMapper;

    public List<InvalidCategory> load() throws SolidaridadException {
        try {
            return invalidCategoryMapper.searchInvalidCategories();
        } catch (Exception e) {
            throw new SolidaridadException("Error to search invalid categories MyBatisInvalidCategory ", e);
        }
    }

    @Override
    public InvalidCategory load(String word) throws SolidaridadException {
        try {
            return invalidCategoryMapper.searchInvalidCategory(word);
        } catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("The invalid category don´t exist");
        }
    }

}