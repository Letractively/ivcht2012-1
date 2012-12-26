package model;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 03.12.12
 * Time: 12:17
 * To change this template use File | Settings | File Templates.
 */
/**/
/**
 *      Класс комплектаций автомобиля
 */
public class Packag {
    private int id;                                   //счетчик
    private int id_types;                             //ссылка на таблицу типов кузова
    private String types;                             //тип кузова из запроса
    private int id_auto;                              //ссылка на родитель автомобиль
   // private String auto;                            //
    private int motor;                                //объем двигателя
    private String transmission;                      //тип трансмиссии
    private String drive;                             //тип привода
    private double price;                             //цена
    private int rating;                               //резерв
    private String datestart;                         //резерв
    private int checked;                              //резерв

    public Packag(){

    }

    public Packag( int id, int id_types, int id_auto, String types,  int motor, String transmission, String drive,double price, int rating, String datestart,int checked)  {
        this.id = id;
        this.id_types = id_types;
        this.types=types;
        this.id_auto=id_auto;
       // this.auto=auto;
        this.motor=motor;
        this.transmission=transmission;
        this.drive=drive;
        this.price=price;
        this.rating=rating;
        this.datestart=datestart;
        this.checked=checked;



}


    public Packag(Integer id_auto, Integer motor, String transmission, String drive, Double price, int checked) {

        this.id_auto=id_auto;
        this.motor=motor;
        this.transmission=transmission;
        this.drive=drive;
        this.checked=checked;
        this.price=price;
    }

    public Packag(Object aPackage) {
        //To change body of created methods use File | Settings | File Templates.
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

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }


    public int getId_auto() {
        return id_auto;
    }

    public void setId_auto(int id_auto) {
        this.id_auto = id_auto;
    }

  /*  public String getAuto() {
        return auto;
    }

    public void setAuto(String auto) {
        this.auto = auto;
    }*/

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
}