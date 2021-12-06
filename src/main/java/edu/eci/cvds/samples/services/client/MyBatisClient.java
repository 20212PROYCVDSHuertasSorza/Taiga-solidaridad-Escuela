package edu.eci.cvds.samples.services.client;
import edu.eci.cvds.samples.entities.*;
import edu.eci.cvds.samples.services.*;
import edu.eci.cvds.samples.services.SolidaridadException;
import edu.eci.cvds.samples.services.SolidaridadFactory;
import org.postgresql.util.PSQLException;
import java.sql.Date;
import java.time.LocalDate;

public class MyBatisClient {
    public static void main(String[] args) throws SolidaridadException, PSQLException {
        UserService userservice = SolidaridadFactory.getInstance().getUserService();
        System.out.println("--------------------------------------------");
        User user = userservice.searchUser("aaa@sss.com");
        System.out.println(user.getNickname());
        System.out.println("--------------------------------------------");
    }
}
