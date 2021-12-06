package edu.eci.cvds.samples.services;
import edu.eci.cvds.samples.entities.Offers;
import java.util.List;



public interface OffersService {
    public abstract void pushOffers(Offers offer) throws SolidaridadException;

    public abstract List<Offers> searchOffers() throws SolidaridadException;

    public abstract void updateOffers(String offersName, String state) throws SolidaridadException;

    Offers searchOffers(String name) throws SolidaridadException;

    int searchNumberOffersState(String state);

}