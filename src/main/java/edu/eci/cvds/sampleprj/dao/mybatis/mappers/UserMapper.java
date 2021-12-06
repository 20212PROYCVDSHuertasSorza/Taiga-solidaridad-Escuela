package edu.eci.cvds.sampleprj.dao.mybatis.mappers;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import edu.eci.cvds.samples.entities.User;

public interface UserMapper {
    List<User> searchUsers();

    User  searchUser(@Param("email") String email);
}

