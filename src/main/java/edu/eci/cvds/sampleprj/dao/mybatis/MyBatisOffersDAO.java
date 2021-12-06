package edu.eci.cvds.sampleprj.dao.mybatis;

import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OffersDAO;
import edu.eci.cvds.sampleprj.dao.mybatis.mappers.OffersMapper;
import edu.eci.cvds.samples.entities.Offers;
import edu.eci.cvds.samples.services.SolidaridadException;

import java.util.List;

public class MyBatisOffersDAO implements OffersDAO {
    @Inject
    private OffersMapper offersMapper;

    @Override
    public void save(Offers offers) throws SolidaridadException {
        try {
            offersMapper.pushOffers(offers);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Offers> load() throws SolidaridadException {
        try {
            return offersMapper.searchOffers();
        } catch (Exception e) {
            throw new SolidaridadException("Error to search the clients MyBatisOfertas ", e);
        }
    }

    @Override
    public void update( String offersName, String state) throws SolidaridadException {
        try{
            if(state!=null) offersMapper.updateState(offersName, state);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("Error to update the state "+state);
        }
    }


    @Override
    public Offers load(String name) throws SolidaridadException {
        try{
            return offersMapper.searchOffer(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("La offer don´t exist");
        }
    }
    @Override
    public List<Offers> searchNumberOffersState(String state) throws SolidaridadException {
        try{
            return offersMapper.searchNumberOffersState(state);
        }
        catch (Exception exception){
            throw new SolidaridadException("Error to search the offers ",exception );
        }
    }
}
