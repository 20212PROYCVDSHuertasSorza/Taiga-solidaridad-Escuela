package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import java.util.List;
import edu.eci.cvds.samples.entities.Neccesities;
import org.apache.ibatis.annotations.Param;

public interface NeccesitiesMapper {
    void pushNeccesities(@Param("neccesities") Neccesities neccesities);

    List<Neccesities> searchNeccesities();
    
    Neccesities searchNeccesity(@Param("name") String name);
    List<Neccesities> searchNumberNeccesitiesState(@Param("state") String state);

    void updateState(@Param("neccesitiesName")String neccesitiesName,@Param("state") String state);
    

}