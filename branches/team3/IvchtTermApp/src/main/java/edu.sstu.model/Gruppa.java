package edu.sstu.model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.11.12
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Gruppa {
    private int id;
    private String namegrupp;
    private String info;
   // public int kolvo;

    public Gruppa(int id, String namegrupp, String info) {
        this.id = id;
        this.namegrupp = namegrupp;
        this.info = info;
       // this.kolvo = kolvo;
    }

    public Gruppa(String namegrupp, String info) {
        this.namegrupp = namegrupp;
        this.info = info;
       // this.kolvo = kolvo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnamegrupp() {
        return namegrupp;
    }

    public void setnamegrupp(String namegrupp) {
        this.namegrupp = namegrupp;
    }


    public void setInfo(String info) {
        this.info = info;
    }



    public String getinfo() {
        return info;
    }



}
