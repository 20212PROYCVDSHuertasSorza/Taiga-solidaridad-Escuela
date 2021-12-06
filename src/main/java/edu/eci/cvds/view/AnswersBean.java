package edu.eci.cvds.view;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import com.google.inject.Inject;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.sql.Date;
import java.util.List;

@ManagedBean(name = "AnswersBean")
@ApplicationScoped
public class AnswersBean extends BasePageBean{

    @Inject
    private AnswersService answersService;

    public void PushAnswers(String name, String comments, int neccesity,int offer, String nickname){
        try{
            if (idOffers==0){
                answersService.PushAnswers(new Answers(name,comments,neccesity,null,nickname));
            }
            if (idNecesidad==0){
                AnswersService.PushAnswers(new Answers(name,comments,null,offer, nickname));
            }
           
        }catch (Exception e){
            System.out.println(offer);
            e.printStackTrace();
        }
    }

    public List<Answers> searchAnswers() throws SolidaridadException{
        try{
            return answersService.searchAnswers();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the answers from AnswersBean");
        }
    }
    public Answers searchAnswer(String name) throws SolidaridadException{
        try{
            return answersService.searchAnswer(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The answer don´t exist");
        }
    }

}