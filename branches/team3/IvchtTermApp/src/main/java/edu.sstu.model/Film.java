package edu.sstu.model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Film {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private int id;
    private String name;
    private String info;
    private String country;
    private Boolean d3;
    private Date date;
    public int genreId;

    public Film() {
    }

    public Film(String name, String info, String country, Boolean d3, Date date, int genreId) {
        this.name = name;
        this.info = info;
        this.country = country;
        this.d3 = d3;
        this.date = date;
        this.genreId = genreId;
    }

    public Film(int id, String name, String info, String country, Boolean d3, Date date, int genreId) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.country = country;
        this.d3 = d3;
        this.date = date;
        this.genreId = genreId;
    }

    public static SimpleDateFormat getSdf() {
        return sdf;
    }

    public static void setSdf(SimpleDateFormat sdf) {
        Film.sdf = sdf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Boolean getD3() {
        return d3;
    }

    public void setD3(Boolean d3) {
        this.d3 = d3;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
