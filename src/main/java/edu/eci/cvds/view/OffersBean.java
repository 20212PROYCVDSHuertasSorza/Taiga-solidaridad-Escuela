package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.OffersService;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.services.UserService;

import org.primefaces.model.chart.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.*;
import javax.annotation.PostConstruct;

import java.sql.Date;
import java.util.List;

@ManagedBean(name = "OffersBean")
@ApplicationScoped
public class OffersBean extends BasePageBean{
    @Inject
    private OffersService offersService;

    @Inject
    private UserService userService;

    private PieChartModel pieModel;
    
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
            pieModel.set("Activas",offersService.searchNumeroOffersState("Activa"));
            pieModel.set("Cerradas",offersService.searchNumeroOffersState("Cerrada"));
            pieModel.set("Resueltas",offersService.searchNumeroOffersState("Resuelta"));
            pieModel.set("En proceso",offersService.searchNumeroOffersState("En proceso"));
            pieModel.setTitle("");
            pieModel.setShowDataLabels(true);
            pieModel.setDataLabelFormatString("%dK");
            pieModel.setLegendPosition("e");
            pieModel.setShowDatatip(true);
            pieModel.setShowDataLabels(true);
            pieModel.setDataFormat("value");
            pieModel.setDataLabelFormatString("%d");
            pieModel.setSeriesColors("ff9c00,17cefa");
            
            
        }catch (Exception e){
            e.printStackTrace();
           
        }
        return pieModel;

    }
    public PieChartModel getPieModel() {
        return pieModel;
    }

    public void setPieModel(PieChartModel pieModel) {
        this.pieModel = pieModel;
    }


    public void pushOffers(String idCategory, String name, String description,String state,String nickname) {
        try {
            Subject subject = SecurityUtils.getSubject();
            String dato = (String) subject.getSession().getAttribute("email");
            System.out.println(dato);            
            user = userService.searchUser(dato);
            String realnick =user.getNickname();
            Integer con =0;
            for (Oferta i: offersService.searchOffers()){
                if (i.getNickname().equals(realnick)){
                    con = con +1  ;
                }
            }
            if( veces<7){
                offersService.pushOffers(new Offers(idCategory,name, description,state,realnick));
            }else{
                throw new SolidaridadException("No more inserts");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Offers searchOffer(String name) throws SolidaridadException{
        try{
            return offersService.searchOffer(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The offer don't exist");
        }
    }

    public void updateState(String offersName,String state) throws SolidaridadException {
        try{
            offersService.updateState(offersName,state);
        }catch (Exception e){
            throw new SolidaridadException("Error to update the state"+state);
        }
    }

    public List<Offers> searchOffers() throws SolidaridadException{
        try{
            return offersService.searchOffers();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the offers from CategoryBean");
        }
    }


}