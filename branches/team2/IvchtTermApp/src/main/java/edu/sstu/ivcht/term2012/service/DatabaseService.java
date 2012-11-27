package edu.sstu.ivcht.term2012.service;


import edu.sstu.ivcht.term2012.dao.DataBaseConnection;


import java.sql.Connection;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author dkinzel
 */
public class DatabaseService {
    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");

        //таблица типов авто содержит только типы кузовов авто
    private final static String CREATE_TYPE_TABLE = "CREATE TABLE Types (id IDENTITY , types VARCHAR(20))";
    private final static String INSERT_TYPE_TABLE = "INSERT INTO Types (id, types) VALUES (1, 'Минивэн') "+
    "INSERT INTO Types (id, types) VALUES (2, 'Кроссовер') "+
            "INSERT INTO Types (id, types) VALUES (3, 'Универсал') "+
            "INSERT INTO Types (id, types) VALUES (4, 'Хэтчбек') "+
            "INSERT INTO Types (id, types) VALUES (5, 'Седан') "+
            "INSERT INTO Types (id, types) VALUES (6, 'Внедорожник')";
    //таблица брендов авто
    private final static String CREATE_TYPE_TABLE_BRAND = "CREATE TABLE Brand (id IDENTITY , brand VARCHAR(20))";
    private final static String INSERT_TYPE_TABLE_BRAND = "INSERT INTO Brand (id, brand) VALUES (1, 'Opel') "+
            "INSERT INTO Brand (id, brand) VALUES (2, 'Audi') "+
            "INSERT INTO Brand (id, brand) VALUES (3, 'Renault') "+
            "INSERT INTO Brand (id, brand) VALUES (4, 'Nissan') "+
            "INSERT INTO Brand (id, brand) VALUES (5, 'Peugeot') "+
            "INSERT INTO Brand (id, brand) VALUES (6, 'Ваз')";
       //таблица автомобилей включает: ссылку на таблицу с брендами машин, число мест в авто, габариты авто и его описание
    private final static String CREATE_TYPE_TABLE_AUTO = "CREATE TABLE Auto (id IDENTITY , id_brand  INTEGER, seat  INTEGER, height  INTEGER, width  INTEGER, len INTEGER, descr VARCHAR(100) )";
    private final static String INSERT_TYPE_TABLE_AUTO = "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (1, 1,5, 1500,1890,4305,'Первый автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (2, 1,5, 1500,1890,4305,'Первый автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (3, 2,5, 1500,1990,4305,'Второй автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (4, 4,7, 1500,1890,4605,'Третий автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (5, 5,7, 1600,1490,4305,'Четвертый автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (6, 3,5, 1500,1750,4005,'Пятый автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (7, 6,5, 1500,1890,4205,'Просто автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (8, 6,5, 1400,1890,4305,'Еще один автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (9, 6,5, 1500,1890,4356,'Опять автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (10, 6,5, 1450,1890,4305,'И снова автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (11, 4,5, 1500,1890,4305,'Юбилейный автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (12, 2,5, 1500,1890,4305,'Новый автомобиль') "+
            "INSERT INTO Auto (id, id_brand, seat, height, width, len, descr) VALUES (13, 1,5, 1500,1890,4305,'Старый автомобиль') ";
       //таблица содержит сведения о комплектации автомобиля
    private final static String CREATE_TYPE_TABLE_PACKAGE = "CREATE TABLE Package (id IDENTITY , id_types  INTEGER, motor INTEGER, transmission varchar(10), drive varchar(10), price FLOAT, raiting INTEGER, datestart DATE, checked BIT )";
       String  INSERT_TYPE_TABLE_PACKAGE="";
     public void createDatabaseTables()  throws Exception{
         //TODO Ошибка, не совпадают форматы даты....
         /*

      try{
           INSERT_TYPE_TABLE_PACKAGE= "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (1, 1,2000, 'MT','2WD',430005,5,"+sdf.parse("2010.01.01")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (2, 2,1600, 'MT','2WD',430005,5,"+sdf.parse("01.01.2010")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (3, 3,2000, 'AT','4WD',530005,9,"+sdf.parse("01.01.2012")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (4, 4,3500, 'MT','2WD',477005,7,"+sdf.parse("01.01.2011")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (5, 5,2000, 'AT','2WD',830005,4,"+sdf.parse("01.01.2009")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (6, 6,2500, 'MT','4WD',430005,2,"+sdf.parse("01.01.2008")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (7, 6,2800, 'AT','2WD',930005,5,"+sdf.parse("01.01.2011")+",0) "+
                  "INSERT INTO Package (id, id_types, motor, transmission, drive, price, raiting,datestart,checked) VALUES (8, 2,1800, 'MT','2WD',730005,1,"+sdf.parse("01.01.2010")+",0) ";

         }
         catch (ParseException e) {
             e.printStackTrace();
         }
         */
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_TYPE_TABLE);
        statement.executeUpdate(INSERT_TYPE_TABLE);
         statement.executeUpdate(CREATE_TYPE_TABLE_BRAND);
         statement.executeUpdate(INSERT_TYPE_TABLE_BRAND);
         statement.executeUpdate(CREATE_TYPE_TABLE_AUTO);
         statement.executeUpdate(INSERT_TYPE_TABLE_AUTO);
         statement.executeUpdate(CREATE_TYPE_TABLE_PACKAGE);
        // statement.executeUpdate(INSERT_TYPE_TABLE_PACKAGE);
        // ... create other table
        statement.close();
    }

}