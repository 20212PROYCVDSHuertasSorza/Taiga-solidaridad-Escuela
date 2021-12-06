package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.CategoryDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.CategoryMapper;
import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;

import java.util.List;

public class MyBatisCategoryDAO implements CategoryDAO {
    @Inject
    private CategoryMapper categoryMapper;

    @Override
    public void save(Category category) throws SolidaridadException {
        try{
            categoryMapper.pushCategory(category);
        }catch (Exception e){
            throw new SolidaridadException("Error for insert the category ",e);
        }
    }

    @Override
    public List<Category> load() throws SolidaridadException  {
        try{
            return categoryMapper.searchCategories();
        }catch (Exception e){
            throw new SolidaridadException("Error for search the category ",e);
        }
    }

    @Override
    public void update(Category category, String name, String description, String state) throws SolidaridadException, PSQLException {
        try{
            String aName = category.getname();
            if (name != null){
                category.setname(name);
            }
            if (description != null){
                category.setdescription(description);
            }
            if (description != null){
                category.setstate(state);
            }
            categoryMapper.update(category,aName);

        }catch (Exception e){
            throw new SolidaridadException("Error to update the category  "+name);
        }
    }

    @Override
    public Category load(String name) throws SolidaridadException {
        try{
            return categoryMapper.searchCategory(name);
        }catch (Exception e){
            throw new SolidaridadException("The category searched don´t exist");
        }
    }
    @Override

    public List<Category> searchNumberCategory(String category) throws SolidaridadException {
        try{
            return categoryMapper.searchNumberCategory(category);
        }
        catch (Exception exception){
            throw new SolidaridadException("Error to search the category ",exception );

        }
    }
   public void delete(String name, int idCategory) throws SolidaridadException {
        try{
            categoryMapper.popCategory(name,idCategory);
        }catch (Exception e){
            //System.out.println("3");
            e.printStackTrace();
        }
   }
}