package edu.eci.cvds.samples.entities;
import java.util.UUID;
import java.sql.Date;
import java.time.LocalDate;


public class InvalidCategory {
    private int idic; //change
    private String word;

    public InvalidCategory(String word){
        this.idic = (int)(Math.random()*1000+1);
        this.word = word;
    }
    public InvalidCategory(int idic,String word){

    }

    public int getidic() {
        return idic;
    }

    public void setidic(int idic) {
        this.idic = idic;
    }

    public String getword() {
        return word;
    }

    public void setword(String word) {
        this.word = word;
    }

    @Override
    public String toString(){
        return "invalidCategory{" + "idic="+idic+", word="+word+"}\n";
    }
}