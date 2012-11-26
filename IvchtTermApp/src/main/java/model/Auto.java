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
    private int id_type;
    private int id_brand;
    private int seat;
    private int length;
    private int width;
    private int height;

   public Auto(){

   }
    public Auto( int id, int id_brand, int id_type, int seat, int length, int width, int height) {
        this.id = id;
        this.id_brand = id_brand;
        this.id_type = id_type;
        this.height = height;
        this.seat=seat;
        this.length=length;
        this.width=width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_type() {
        return id_type;
    }

    public void setId_type(int id_type) {
        this.id_type = id_type;
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

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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