package model;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 20.11.12
 * Time: 10:23
 * To change this template use File | Settings | File Templates.
 */

/**
 *
 */
public class Auto {
    private int id;
    private int id_brand;
    private int id_types;
    private String types;
    private int seat;
    private int len;
    private int width;
    private int height;
    private String descr;
    private String brand;
    private String model;
    private double price;
    private int rating;
    private String datest;




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

    public Auto( int id, int id_brand,int id_types, String types, int seat, int height, int width,int len,  String descr, String brand, String model, double  price, int rating,String datest) {
        this.id = id;
        this.id_brand = id_brand;
        this.id_types=id_types;
        this.types=types;
        this.height = height;
        this.seat=seat;
        this.len=len;
        this.width=width;
        this.descr=descr;
        this.brand=brand;
        this.model=model;
        this.price=price;
        this.rating=rating;
        this.datest=datest;
    }

    public Auto(int id, int id_brand, int id_types, String model, int height, int width, int len, int seat, int rating, String descr, double price) {
        //To change body of created methods use File | Settings | File Templates.
        this.id=id;
        this.id_brand = id_brand;
        this.id_types=id_types;
        this.height = height;
        this.seat=seat;
        this.len=len;
        this.width=width;
        this.descr=descr;
        this.model=model;
        this.price=price;
        this.rating=rating;

    }



    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getId_types() {
        return id_types;
    }

    public void setId_types(int id_types) {
        this.id_types = id_types;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDatest() {
        return datest;
    }

    public void setDatest(String datest) {
        this.datest = datest;
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