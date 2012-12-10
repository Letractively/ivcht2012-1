package edu.sstu.model;

import java.text.SimpleDateFormat;
import java.util.Date;

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
    private String genre;
    private String info;
    private Date date;

    public Genre(int id, String genre, String info, Date date) {
        this.id = id;
        this.genre = genre;
        this.info = info;
        this.date = date;
    }

    public Genre(String genre, String info, Date date) {
        this.genre = genre;
        this.info = info;
        this.date = date;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}
