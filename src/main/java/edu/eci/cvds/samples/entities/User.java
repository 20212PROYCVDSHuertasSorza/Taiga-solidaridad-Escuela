package edu.eci.cvds.samples.entities;

public class User {
    private String nickname;
    private String name;
    private String lastname;
    private String email;
    private String state;
    private String password;
    private int idrol;
    
    public User(String nickname, String name,String lastname,String email, String state, String password,int idrol){
        this.nickname = nickname;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.state = state;
        this.password = password;
        this.idrol = idrol;
    }

    
 
    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getState() {
        return this.state;
    }

    public void setstate(String state) {
        this.state = state;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdrol() {
        return this.idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

    @Override
    public String toString(){
        return "User{" + "nickname="+nickname+", name="+name+",lastname="+lastname+", email="+email+", state="+state+", password="+password+", idrol="+idrol+"}\n";
    }
}
    