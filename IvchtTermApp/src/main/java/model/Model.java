package model;

import java.security.PublicKey;

/**
 * Created with IntelliJ IDEA.
 * User: XPMUser
 * Date: 26.11.12
 * Time: 19:41
 * To change this template use File | Settings | File Templates.
 */
public class Model {
     private int id;
    private int id_auto;
    private int year;
    private String datestart;

    public Model(){

    }

      public Model(int id, int id_auto, int year, String datestart){
          this.id=id;
          this.id_auto=id_auto;
          this.year=year;
          this.datestart=datestart;

      }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }
}
