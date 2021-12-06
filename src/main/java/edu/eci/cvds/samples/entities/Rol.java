package edu.eci.cvds.samples.entities;

public class Rol {
    private int idrol;
    private String name;

    
    public Rol(int idrol, String name){
        this.idrol = idrol;
        this.name = name;
       
    }

    @Override
    public String toString(){
        return "User{" + "idrol="+idrol+", name="+name+"}\n";
    }
 
    public int getIdrol() {
        return this.idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

    