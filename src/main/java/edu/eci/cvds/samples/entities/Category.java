package edu.eci.cvds.samples.entities;
import java.util.UUID;
import java.sql.Date;
import java.time.LocalDate;


public class Category {
    private int idCategory;
    private String name;
    private String description;
    private Date creationDate;
    private String state;
    private Date modificationDate;

    public Category(String name, String description){
        this.idCategory = (int)(Math.random()*1000+1);
        this.name = name;
        this.description = description;
        this.creationDate = Date.valueOf(LocalDate.now());
        this.state = "True";
        this.modificationDate = Date.valueOf(LocalDate.now());
    }
    public Category(int idCategory,String name, String description, Date creationDate,String state, Date modificationDate){

    }

    public int getidCategory() {
        return idCategory;
    }

    public void setidCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }

    public Date getcreationDate() {
        return creationDate;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getstate() {
        return state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public Date getmodificationDate() {
        return modificationDate;
    }

    public void setmodificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    @Override
    public String toString(){
        return "Category{" + "idCategory="+idCategory+", name="+name+", description="+description+", state="+state+"}\n";
    }
}