package model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 20.11.12
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */

public class Auto {
    private int id;
    private int id_brand;
    private int seat;
    private int len;
    private int width;
    private int height;
    private String descr;
    private String brand;
    private String model;


    public Auto(){

   }
  /*  public Auto(int id, String brand,int seat, int len, int width, int height, String descr)  {
        this.id = id;
        this.brand = brand;
        this.height = height;
        this.seat=seat;
        this.len=len;
        this.width=width;
        this.descr=descr;
    }*/

    public Auto( int id, int id_brand,  int seat, int len, int width, int height, String descr, String brand, String model) {
        this.id = id;
        this.id_brand = id_brand;
        this.height = height;
        this.seat=seat;
        this.len=len;
        this.width=width;
        this.descr=descr;
        this.brand=brand;
        this.model=model;
    }


    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getLen() {
        return len;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getId_brand() {
        return id_brand;
    }

    public void setId_brand(int id_brand) {
        this.id_brand = id_brand;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

      public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}