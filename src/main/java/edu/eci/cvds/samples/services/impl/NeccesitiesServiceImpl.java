package edu.eci.cvds.samples.services.impl;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.NeccesitiesDAO;
import edu.eci.cvds.samples.entities.Neccesities;
import edu.eci.cvds.samples.services.NeccesitiesService;
import edu.eci.cvds.samples.services.SolidaridadException;
import javax.transaction.Transactional;
import java.util.List;

public class NeccesitiesServiceImpl implements NeccesitiesService {
    @Inject
    private NeccesitiesDAO NeccesitiesDAO;

    @Transactional
    @Override
    public void  pushNeccesities(Neccesities Neccesities) throws SolidaridadException {
        try{
            NeccesitiesDAO.save(Neccesities);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Neccesities> searchNeccesities() throws SolidaridadException {
        try{
            return NeccesitiesDAO.load();
        }catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("not found Neccesities");
        }
    }

    @Override
    public void updateNeccesities(String nameNeccesities, String state) throws SolidaridadException {
        try{
            NeccesitiesDAO.update(nameNeccesities,state);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("cant update the state "+state);
        }
    }

    @Override
    public Neccesities searchNeccesities(String name) throws SolidaridadException {
        try{
            return NeccesitiesDAO.load(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La Neccesities "+name+" doesnt exist");
        }
    }   
    
    @Override
    public int searchNumberNeccesitiesState(String state) {
        try{
            return NeccesitiesDAO.searchNumberNeccesitiesState(state).size();
        }
        catch (Exception e){
            return 0;
        }
    }
}


