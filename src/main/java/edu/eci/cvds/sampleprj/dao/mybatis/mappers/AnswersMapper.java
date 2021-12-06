package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import java.util.List;
import edu.eci.cvds.samples.entities.Answers;
import org.apache.ibatis.annotations.Param;

public interface AnswersMapper {
    void PushAnswers(@Param("answers") Answers Answers);

    List<Answers> searchAnswers();

	Answers searchAnswer(@Param("name")String name);
    
}