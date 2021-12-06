package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NeccesitiesDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.NeccesitiesMapper;
import edu.eci.cvds.samples.entities.Neccesities;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public class MyBatisNeccesitiesDAO implements NeccesitiesDAO {
    @Inject
    private NeccesitiesMapper NeccesitiesMapper;

    @Override
    public void save(Neccesities neccesity) throws SolidaridadException {
        try{
            NeccesitiesMapper.pushNeccesities(neccesity);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    @Override
    public List<Neccesities> load() throws SolidaridadException  {
        try{
            return NeccesitiesMapper.searchNeccesities();
        }catch (Exception e){
            throw new SolidaridadException("Error to search the clients from MyBatisNeccesities ",e);
        }
    }

    @Override
    public void update( String neccesitiesName, String state) throws SolidaridadException {
        try{
          if(state!=null) NeccesitiesMapper.updateState(neccesitiesName, state); 
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Error to update the state of Neccesity "+state);
        }
    }

    @Override
    public Neccesities load(String name) throws SolidaridadException {
        try{
            return NeccesitiesMapper.searchNeccesity(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("The neccesity don´t exist");
        }
    }

    @Override
    public List<Neccesities> searchNumberNeccesitiesState(String state) throws SolidaridadException {
        try{
            return NeccesitiesMapper.searchNumberNeccesitiesState(state);
        }
        catch (Exception exception){
            throw new SolidaridadException("Error to search ",exception );
        }
    }


    }