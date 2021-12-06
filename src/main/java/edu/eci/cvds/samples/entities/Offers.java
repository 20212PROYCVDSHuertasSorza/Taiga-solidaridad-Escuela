package edu.eci.cvds.samples.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.sql.Date;
import java.util.UUID;


public class Offers {

    private int idOffers;
    private int idCategory;
    private String name;
    private String description;
    private Date creationDate;
    private String state;
    private Date modificationDate;
    private String nickname;

   public Offers(int idCategory,String name,String description,String state, String nickname){

       this.idOffers=(int)(Math.random()*1000+1);
       this.idCategory=idCategory;
       this.name=name;
       this.description=description;
       this.creationDate= Date.valueOf(LocalDate.now());
       this.state=state;
       this.modificationDate=Date.valueOf(LocalDate.now());
       this.nickname= nickname;
   }

    public Offers(int idOffers, int idCategory,String name,String description, Date creationDate, String state , Date modificationDate,String nickname) {
    }

    public int getIdOffers() {
       return idOffers;
    }

    public void setIdOffers(int idOffers) {
       this.idOffers = idOffers;
    }

    public int getidCategory() {
       return this.idCategory;
    }

    public void setidCategory(int idCategory) {
       this.idCategory = idCategory;
    }


    public String getname() {
       return this.name;
    }

    public void setname(String name) {
       this.name = name;
    }

    public String getdescription() {
       return this.description;
    }

    public void setdescription(String description) {
       this.description = description;
    }

    public Date getcreationDate() {
       return this.creationDate;
    }

    public void setcreationDate(Date creationDate) {
       this.creationDate = creationDate;
    }

    public String getstate() {
       return this.state;
    }

    public void setstate(String state) {
       this.state = state;
    }

    public Date getmodificationDate() {
        return this.modificationDate;
    }

    public void setmodificationDate(Date modificationDate) {
       this.modificationDate = modificationDate;
    }

    public String getNickname() {
       return this.nickname;
    }

    public void setNickname(String nickname) {
       this.nickname = nickname;
    }

    @Override
    public String toString(){
        return "Offers{" + "idOffers="+idOffers+"," + "idCategory= "+idCategory+", " + "name="+name+", " + "description="+description+"" + ", state="+state+"}\n";
    }
}
