package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import java.util.List;
import edu.eci.cvds.samples.entities.Offers;
import org.apache.ibatis.annotations.Param;

public interface OffersMapper {
    void pushOffers(@Param("offers") Offers offers);//Cambio
    List<Offers> searchOffers();
    List<Offers> searchNumberOffersState(@Param("state") String state);

    Offers searchOffer(@Param("name") String name);

    void updateState(@Param("offersName")String offersName,@Param("state") String state);

}