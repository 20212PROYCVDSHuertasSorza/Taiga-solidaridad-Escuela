package edu.eci.cvds.sampleprj.dao.mybatis;

import edu.eci.cvds.sampleprj.dao.AnswersDAO;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.*;
import edu.eci.cvds.samples.entities.Answers;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public class MyBatisAnswersDAO implements AnswersDAO {
    @Inject
    private AnswersMapper AnswersMapper;

    @Override
    public void save(Answers Answers) throws SolidaridadException {
        try{
            AnswersMapper.PushAnswers(Answers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Answers> load() throws SolidaridadException  {
        try{
            return AnswersMapper.searchAnswers();
        }catch (Exception e){
            throw new SolidaridadException("Error for looking Answers ",e);
        }
    }
    @Override
    public Answers load(String name) throws SolidaridadException {
        try{
            return AnswersMapper.searchAnswer(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The neccesity don't exist");
        }
    }


}