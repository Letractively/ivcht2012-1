package edu.sstu.model;

import java.text.SimpleDateFormat;

/**
 * Created with IntelliJ IDEA.
 * User: Admin
 * Date: 25.11.12
 * Time: 19:18
 * To change this template use File | Settings | File Templates.
 */
public class Genre {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private int id;
    private String name;
    private String info;
    private String text;

    public Genre() {
    }

    public Genre(int id, String name, String info, String text) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.text = text;

    }

    public Genre(String name, String info, String text) {
        this.name = name;
        this.info = info;
        this.text = text;
      }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        Genre.sdf = sdf;
    }

    public int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }



    public void setText(String text) {
        this.text = text;
    }


    public String getText() {
        return text;
    }


}
