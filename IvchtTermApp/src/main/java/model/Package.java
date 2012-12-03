package model;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 16:14
 * To change this template use File | Settings | File Templates.
 */
public class Package {
    private int id;
    private int id_types;
    private String types;
    private int id_auto;
    private int motor;
    private String transmission;
    private String drive;
    private double price;
    private int rating;
    private String datestart;
    private int checked;

    public Package(){

    }

    public Package( int id, int id_types, String types, int id_auto, int motor, String transmission, String drive, double price, int rating, String datestart, int checked)  {
        this.id = id;
        this.id_types = id_types;
        this.types=types;
        this.id_auto=id_auto;
        this.motor=motor;
        this.transmission=transmission;
        this.drive=drive;
        this.price=price;
        this.rating=rating;
        this.datestart=datestart;
        this.checked=checked;


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_types() {
        return id_types;
    }

    public void setId_types(int id_types) {
        this.id_types = id_types;
    }

    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public int getMotor() {
        return motor;
    }

    public void setMotor(int motor) {
        this.motor = motor;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDatestart() {
        return datestart;
    }

    public void setDatestart(String datestart) {
        this.datestart = datestart;
    }

    public int getChecked() {
        return checked;
    }

    public void setChecked(int checked) {
        this.checked = checked;
    }
}
