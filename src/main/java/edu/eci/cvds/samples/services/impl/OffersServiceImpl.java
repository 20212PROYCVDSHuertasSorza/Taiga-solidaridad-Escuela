package edu.eci.cvds.samples.services.impl;
import com.google.inject.Inject;
import edu.eci.cvds.sampleprj.dao.OffersDAO;
import edu.eci.cvds.samples.entities.Offers;
import edu.eci.cvds.samples.services.OffersService;
import edu.eci.cvds.samples.services.SolidaridadException;
import javax.transaction.Transactional;
import java.util.List;

public class OffersServiceImpl implements OffersService {
    @Inject
    private OffersDAO offersDAO;

    @Transactional
    @Override
    public void pushOffers(Offers offers) throws SolidaridadException {
        try{
            offersDAO.save(offers);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Offers> searchOffers() throws SolidaridadException {
        try {
            return offersDAO.load();
        } catch (Exception e) {
            e.printStackTrace();
            throw new SolidaridadException("not clients");
        }
    }
    @Override
    public void updateOffers(String nameOffers, String state) throws SolidaridadException {
        try{
            offersDAO.update(nameOffers,state);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("cant update the state "+state);
        }
    }

    @Override
    public Offers searchOffers(String name) throws SolidaridadException {
        try{
            return offersDAO.load(name);
        }catch (Exception e){
            e.printStackTrace();
            throw new SolidaridadException("the offers "+name+" doesnt exist");
        }
    }
    @Override
    public int searchNumberOffersState(String state) {
        try{
            return offersDAO.searchNumberOffersState(state).size();
        }
        catch (Exception e){
            return 0;
        }
    }
}

