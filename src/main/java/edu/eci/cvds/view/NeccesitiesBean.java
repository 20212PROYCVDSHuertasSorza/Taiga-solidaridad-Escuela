package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import org.primefaces.model.chart.*;
import javax.annotation.PostConstruct;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.*;
import java.sql.Date;
import java.util.List;

@ManagedBean(name = "NeccesitiesBean")
@ApplicationScoped
public class NeccesitiesBean extends BasePageBean{
    @Inject
    private NeccesitiesService neccesitiesService;
    private PieChartModel pieModel;

    @Inject
    private UserService userService;
    private User user;


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
           

            pieModel.set("Activas",neccesitiesService.searchNumberNeccesitiesState("Activa"));
            pieModel.set("Cerradas",neccesitiesService.searchNumberNeccesitiesState("Cerrada"));
            pieModel.set("Resueltas",neccesitiesService.searchNumberNeccesitiesState("Resuelta"));
            pieModel.set("En proceso",neccesitiesService.searchNumberNeccesitiesState("En proceso"));
            pieModel.setTitle("");
            pieModel.setShowDataLabels(true);
            pieModel.setDataLabelFormatString("%dK");
            pieModel.setLegendPosition("e");
            pieModel.setShowDatatip(true);
            pieModel.setShowDataLabels(true);
            pieModel.setDataFormat("value");
            pieModel.setDataLabelFormatString("%d");
            pieModel.setSeriesColors("ff8c10,84cefa");
            
            
        }catch (Exception e){
            e.printStackTrace();
           
        }
        return pieModel;

    }

    public void pushNeccesities( String name, String description, String idCategory, String urgency, String nickname){
        try{
            Subject subject = SecurityUtils.getSubject();
            String data = (String) subject.getSession().getAttribute("email");
            System.out.println(data);            
            user = userService.searchUser(data);
            String realnick =user.getNickname();
            Integer a =0;
            for (Neccesities i: neccesitiesService.searchNeccesities()){
                if (i.getNickname().equals(realnick)){
                    a = a +1  ;
                }
            }
            if( a<6){
                neccesitiesService.pushNeccesities(new Neccesities(name, description,idCategory,urgency,realnick));
            }else{
                throw new SolidaridadException("No more inserts");
            }
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Neccesities> searchNeccesities() throws SolidaridadException{
        try{
            return neccesitiesService.searchNeccesities();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the neccesities in NecesidadesBean");
        }
    }

    public void updateState(String neccesitiesName,String state) throws SolidaridadException {
        try{
            neccesitiesService.updateState(neccesitiesName,state);
        }catch (Exception e){
            throw new SolidaridadException("Error to update the neccesity "+state);
        }
    }
    public Neccesities searchNeccesity(String name) throws SolidaridadException{
        try{
            return neccesitiesService.searchNeccesities(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The neccesity don't exist");
        }
    }
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }

}