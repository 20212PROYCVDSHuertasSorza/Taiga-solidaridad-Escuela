package edu.eci.cvds.sampleprj.dao;
import edu.eci.cvds.samples.entities.Offers;
import edu.eci.cvds.samples.services.SolidaridadException;
import java.util.List;

public interface OffersDAO{

        void save(Offers Offers) throws SolidaridadException;

        List<Offers> load() throws SolidaridadException;

        void update(String nameOffers,String state) throws SolidaridadException;

        Offers load(String name) throws SolidaridadException;

        public List<Offers> searchNumberOffersState( String state) throws SolidaridadException;
}
