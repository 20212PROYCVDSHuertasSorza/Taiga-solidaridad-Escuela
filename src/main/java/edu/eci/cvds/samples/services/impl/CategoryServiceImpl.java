package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.CategoryDAO;
import edu.eci.cvds.samples.entities.Category;
import edu.eci.cvds.samples.services.CategoryService;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;

import javax.transaction.Transactional;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Inject
    private CategoryDAO CategoryDAO;

    @Transactional
    @Override
    public void pushCategory(Category Category) throws SolidaridadException {
        try{
            CategoryDAO.save(Category);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> searchCategories() throws SolidaridadException {
        try{
            return CategoryDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("not found clients");
        }
    }

    @Override
    public void updateCategory(String CategoryName, String name, String description, String state) throws SolidaridadException, PSQLException {
        try{
            Category Category = searchCategory(CategoryName);
            CategoryDAO.update(Category,name,description,state);
        }catch (Exception e){
            throw new SolidaridadException("cant update the Category "+name);
        }
    }

    @Override
    public Category searchCategory(String name) throws SolidaridadException {
        try{
            return CategoryDAO.load(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The Category "+name+" doesnt exist");
        }
    }
    @Override
    public int searchNumberCategory(String Category) {
        try{
            System.out.println(CategoryDAO.searchNumberCategory(Category).size());
            return CategoryDAO.searchNumberCategory(Category).size();
        }
        catch (Exception e){
            return 0;
        }
    }

    @Override
    public void deleteCategory(String name,int idCategory) throws SolidaridadException {
        try{
            CategoryDAO.delete(name, idCategory);
        }catch (Exception e){
            System.out.println("2");
            e.printStackTrace();
        } 
        
    }

}
