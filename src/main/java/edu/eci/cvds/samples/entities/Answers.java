package edu.eci.cvds.samples.entities;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Random;
public class Answers {
    private int idAnswer;
    private String name;
    private String comments;
    private Date creationDate;
    private int offer;
    private int neccesity;
    private String nickname;

    public Answers(String name, String comments, int neccesity,int  offer, String nickname){
        this.idAnswer= (int)(Math.random()*1000+1);
        this.offer = offer;
        this.neccesity = neccesity;
        this.name = name;
        this.comments = comments;
        this.creationDate = Date.valueOf(LocalDate.now());
        this.nickname = nickname;
    }
    public Answers(int idAnswer,int neccesity, int offer, String name, String comments, Date creationDate, Date fechaDeModificacion,String nickname){
    }
    public int getidAnswer() {
        return this.idAnswer;
    }

    public void setidAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public int getneccesity() {
        return this.neccesity;
    }

    public void setneccesity(int neccesity) {
        this.neccesity = neccesity;
    }

    public int getoffer() {
        return this.offer;
    }

    public void setoffer(int offer) {
        this.offer = offer;
    }

    public String getname() {
        return this.name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getcomments() {

        return this.comments;

    }

    public void setcomments(String comments) {
        this.comments = comments;
    }


    public Date getcreationDate() {
        return this.creationDate;
    }

    public void setcreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getNickname() {
        return this.nickname;

    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString(){
        return "Answers{" + "idAnswer="+idAnswer+ "neccesity="+neccesity+", name="+name+", comments="+comments+", nickname="+nickname+", fechacreacion="+creationDate+"}\n";
    }
}