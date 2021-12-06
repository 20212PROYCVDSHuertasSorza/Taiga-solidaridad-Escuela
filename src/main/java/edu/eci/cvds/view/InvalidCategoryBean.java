package edu.eci.cvds.view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.InvalidCategory;
import edu.eci.cvds.samples.services.InvalidCategoryService;
import edu.eci.cvds.samples.services.SolidaridadException;


import java.util.List;

@ManagedBean(name = "InvalidCategoryBean")
@ApplicationScoped
public class InvalidCategoryBean extends BasePageBean{
    @Inject
    private InvalidCategoryService invalidCategoryService;

    public InvalidCategory searchInvalidCategory(String word) throws SolidaridadException{
        try{
            return invalidCategoryService.searchInvalidCategory(word);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The category don´t exist");
        }
    }

    public List<InvalidCategory> searchInvalidCategories() throws SolidaridadException{
        try{
            return invalidCategoryService.searchInvalidCategories();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the invlid categories of  CategoryBean");
        }
    }

}