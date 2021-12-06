package edu.eci.cvds.samples.services.impl;

import edu.eci.cvds.samples.services.AnswersService;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.AnswersDAO;
import edu.eci.cvds.samples.entities.Answers;
import edu.eci.cvds.samples.services.*;
import javax.transaction.Transactional;
import java.util.List;


public class AnswersServiceImpl implements AnswersService {
    @Inject
    private AnswersDAO AnswersDAO;

    @Transactional
    @Override
    public void pushAnswers(Answers Answers) throws SolidaridadException {
        try{
            AnswersDAO.save(Answers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Answers> searchAnswers() throws SolidaridadException {
        try{
            return AnswersDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("not found Answers");
        }
    }
    @Override
    public Answers searchAnswers(String name) throws SolidaridadException {
        try{
            return AnswersDAO.load(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("necesity "+name+" does not exist");
        }
    }   

}