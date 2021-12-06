package edu.eci.cvds.samples.entities;
import java.util.UUID;
import java.sql.Date;
import java.time.LocalDate;

public class Neccesities {
    private int idNecessity;
    private int idCategory;
    private String name;
    private String description;
    private String urgency;
    private Date creationDate;
    private String state;
    private Date modificationDate;
    private String nickname;

    public Neccesities(String name, String description, int idCategory, String urgency, String nickname){
        this.idNecessity = (int)(Math.random()*1000+1);
        this.idCategory = idCategory;
        this.name = name;
        this.description = description;
        this.urgency = urgency;
        this.creationDate = Date.valueOf(LocalDate.now());
        this.state = "True";
        this.modificationDate = Date.valueOf(LocalDate.now());
        this.nickname=nickname;
    }
    
    public int getidNecessity() {
        return this.idNecessity;
    }

    public void setidNecessity(int idNecessity) {
        this.idNecessity = idNecessity;
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

    public String geturgency() {
        return this.urgency;
    }

    public void seturgency(String urgency) {
        this.urgency = urgency;
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
    

}