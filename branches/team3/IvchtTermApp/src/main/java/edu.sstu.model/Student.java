package edu.sstu.model;


import java.text.SimpleDateFormat;
import java.util.Date;

public class Student {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private int id;
    private String firstName;
    private String secondName;
    private Date birthday;
    public int height;
    public int grId;

    public Student() {
    }

    public Student(String firstName, String secondName, Date birthday, int height, int grId) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.height = height;
        this.grId = grId;
    }

    public Student(int id, String firstName, String secondName, Date birthday, int height, int grId) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.birthday = birthday;
        this.height = height;
        this.grId = grId;
    }

    public int getHeight() {
        return height;
    }

    public int getGrId() {
        return grId;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public void setId (int id) {
        this.id = id;
    }
    public void setGrId (int grId) {
        this.grId = grId;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getFbirthday() {

        return sdf.format(birthday) ;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }
}
