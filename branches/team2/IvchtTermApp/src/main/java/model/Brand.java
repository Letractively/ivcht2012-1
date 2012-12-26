package model;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 28.11.12
 * Time: 13:26
 * To change this template use File | Settings | File Templates.
 */


/**
 * Марки автомобиля
 */
public class Brand {
    private int id;
    private String brand;



    public Brand(){

    }

    public Brand( int id, String brand) {
        this.id = id;
        this.brand = brand;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
