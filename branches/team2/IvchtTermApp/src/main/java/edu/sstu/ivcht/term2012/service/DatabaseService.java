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
    private final static String CREATE_TYPE_TABLE_AUTO = "CREATE TABLE Auto (id IDENTITY , id_brand  INTEGER, id_types INTEGER, seat  INTEGER, height  INTEGER, width  INTEGER, len INTEGER, descr VARCHAR(100), model VARCHAR(100),price FLOAT,rating INTEGER,datest DATE )";
    private final static String INSERT_TYPE_TABLE_AUTO = "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (1, 1,1,5, 1500,1890,4305,'Первый автомобиль', 'Meriva',430005,5,'2010-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (2, 1,2,5, 1500,1890,4305,'Первый автомобиль', 'Astra',440005,5,'2009-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (3, 2,3,5, 1500,1990,4305,'Второй автомобиль', 'A4',450005,5,'2011-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (4, 4,4,7, 1500,1890,4605,'Третий автомобиль', 'Qashqai',460005,5,'2011-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (5, 5,5,7, 1600,1490,4305,'Четвертый автомобиль', '4007',470005,5,'2012-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (6, 3,5,6, 1500,1750,4005,'Пятый автомобиль', 'Sandero',480005,5,'2008-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (7, 6,5,4, 1500,1890,4205,'Просто автомобиль', 'Калина',490005,5,'2007-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (8, 6,5,3, 1400,1890,4305,'Еще один автомобиль', 'Гранта',500005,5,'2009-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (9, 6,5,2, 1500,1890,4356,'Опять автомобиль', 'Лада',510005,5,'2010-07-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (10, 6,5,6, 1450,1890,4305,'И снова автомобиль', 'Нива',520005,5,'2010-11-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (11, 4,5,2, 1500,1890,4305,'Юбилейный автомобиль', 'Almera',530005,5,'2010-11-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (12, 2,5,1, 1500,1890,4305,'Новый автомобиль', 'A6',540005,5,'2010-01-01') "+
            "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES (13, 1,5,6, 1500,1890,4305,'Старый автомобиль', 'Insignia',550005,5,'2010-01-01') ";
       //таблица содержит сведения о комплектации автомобиля
    private final static String CREATE_TYPE_TABLE_PACKAGE = "CREATE TABLE Package (id IDENTITY , id_types  INTEGER,id_auto INTEGER,  motor INTEGER, transmission varchar(10), drive varchar(10), price FLOAT, rating INTEGER, datestart DATE, checked BIT )";
       String  INSERT_TYPE_TABLE_PACKAGE="";
     public void createDatabaseTables()  throws Exception{
         //TODO Ошибка, не совпадают форматы даты....


         INSERT_TYPE_TABLE_PACKAGE= "INSERT INTO Package (id, id_types, id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (1, 1,1,2000, 'MT','2WD',430005,5,'2010-01-01',0) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (2, 2,1,1600, 'MT','2WD',430005,5,'2010-07-01',1) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (3, 3,2,2000, 'AT','4WD',530005,9,'2010-01-01',0) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (4, 4,3,3500, 'MT','2WD',477005,7,'2011-01-01',0) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (5, 5,4,2000, 'AT','2WD',830005,4,'2012-01-01',1) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (6, 6,5,2500, 'MT','4WD',430005,2,'2010-06-01',0) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (7, 6,6,2800, 'AT','2WD',930005,5,'2011-01-01',0) "+
              "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES (8, 2,3,1800, 'MT','2WD',730005,1,'2010-09-01',1) ";

         Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_TYPE_TABLE);
        statement.executeUpdate(INSERT_TYPE_TABLE);
         statement.executeUpdate(CREATE_TYPE_TABLE_BRAND);
         statement.executeUpdate(INSERT_TYPE_TABLE_BRAND);
         statement.executeUpdate(CREATE_TYPE_TABLE_AUTO);
         statement.executeUpdate(INSERT_TYPE_TABLE_AUTO);
         statement.executeUpdate(CREATE_TYPE_TABLE_PACKAGE);
         statement.executeUpdate(INSERT_TYPE_TABLE_PACKAGE);
        // ... create other table
        statement.close();
    }

}
