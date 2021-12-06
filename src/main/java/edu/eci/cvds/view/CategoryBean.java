package edu.eci.cvds.view;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.postgresql.util.PSQLException;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;


import java.sql.Date;
import java.util.List;
@ManagedBean(name = "CategoryBean")
@ApplicationScoped
public class CategoryBean extends BasePageBean{
    @Inject
    private CategoryService categoryService;
  @Inject
    private InvalidCategoryService invalidCategoryService;

    private PieChartModel pieModel;

    @PostConstruct
    public void init() {
        super.init();
        try {
            
            pieModel= createPieModel();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    private PieChartModel  createPieModel()  {
        pieModel = new PieChartModel();
        try{
           

            pieModel.set("Jillene",categoryService.searchNumberCategory("Jillene"));
            System.out.println("Jillene");
            pieModel.set("Calculo Diferencial",categoryService.searchNumberCategory("Calculo Diferencial"));
            pieModel.set("Diferencial",categoryService.searchNumberCategory("Diferencial"));
            pieModel.set("Integral",categoryService.searchNumberCategory("Integral"));
            pieModel.set("Ecuaciones",categoryService.searchNumberCategory("Ecuaciones"));
            pieModel.set("Programacion",categoryService.searchNumberCategory("Programacion"));
            pieModel.set("CVDS",categoryService.searchNumberCategory("CVDS"));
            pieModel.set("POOB",categoryService.searchNumberCategory("POOB"));
            pieModel.set("ARSW",categoryService.searchNumberCategory("ARSW"));
            pieModel.set("Winne",categoryService.searchNumberCategory("Winne"));
            pieModel.set("Yolis",categoryService.searchNumberCategory("Yolis"));
            pieModel.set("Calculo integral",categoryService.searchNumberCategory("Calculo integral"));
            pieModel.set("Fiorenze",categoryService.searchNumberCategory("Fiorenze"));
            pieModel.setTitle("");
            System.out.println("title");
            pieModel.setShowDataLabels(true);
            System.out.println("datalabels");
            pieModel.setDataLabelFormatString("%dK");
            System.out.println("dataformat");
            pieModel.setLegendPosition("e");
            System.out.println("setlegenf");
            pieModel.setShowDatatip(true);
            System.out.println("dataship");
            pieModel.setShowDataLabels(true);
            System.out.println("datalabels");
            pieModel.setDataFormat("value");
            System.out.println("dataformat");
            pieModel.setDataLabelFormatString("%d");
            System.out.println("datalabelformat");
            pieModel.setSeriesColors("ff0000,ff4200,ff8200 ,ffbf10,ffff10,bfff20,80ff10,40ff00,00ff00,00ff40,00ff80,00ffbf,00ffff");
            System.out.println("color");
            
            
        }catch (Exception e){
            e.printStackTrace();
           
        }
        return pieModel;

    }



    public void pushCategory( String name, String description){

        try{
            boolean valid = true;
            for (InvalidCategory i: invalidCategoryService.searchInvalidCategories()){
                if (i.getword().contains(name)){
                    valid=false ;
                    break;   
                }
            }
            if (valid){
                categoryService.pushCategory(new Category(name, description));

            }else{
                throw new SolidaridadException("The category is not valid");
            }

    

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void popCategory( String name, String idCategory)throws SolidaridadException{
        try{
            categoryService.popCategory(name, idCategory);
        }catch (Exception e){
            System.out.println("0");
            e.printStackTrace();
        }
    }
    public Category searchCategory(String name) throws SolidaridadException{
        try{
            return categoryService.searchCategory(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The category don't exist");
        }
    }

    public List<Category> searchCategories() throws SolidaridadException{
        try{
            return categoryService.searchCategories();
        }catch (Exception e){
            throw new SolidaridadException("Error for search the categories ne CategoriasBean");
        }
    }

    public void update(String name, String name, String description, String state) throws SolidaridadException, PSQLException {
        try{
            categoryService.update(name,name,descripcion,state);
        }catch (Exception e){
            throw new SolidaridadException("Error to update the category "+name);
        }
    }

    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

    
}