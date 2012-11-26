package edu.sstu.ivcht.term2012.service;


import edu.sstu.ivcht.term2012.dao.DataBaseConnection;


import java.sql.Connection;
import java.sql.Statement;

/**
 * @author dkinzel
 */
public class DatabaseService {
    private final static String CREATE_TYPE_TABLE = "CREATE TABLE Auto (id IDENTITY , type VARCHAR(20))";
    private final static String INSERT_TYPE_TABLE = "INSERT Type (id, type) VALUES (1, 'Минивэн') "+
    "INSERT Type (id, type) VALUES (2, 'Кроссовер') "+
            "INSERT Type (id, type) VALUES (3, 'Универсал') "+
            "INSERT Type (id, type) VALUES (4, 'Хэтчбек') "+
            "INSERT Type (id, type) VALUES (5, 'Седан') "+
            "INSERT Type (id, type) VALUES (6, 'Внедорожник')";
    private final static String CREATE_TYPE_TABLE_BRAND = "CREATE TABLE Brand (id IDENTITY , brand VARCHAR(20))";
    private final static String INSERT_TYPE_TABLE_BRAND = "INSERT Brand (id, type) VALUES (1, 'Opel') "+
            "INSERT Brand (id, type) VALUES (2, 'Audi') "+
            "INSERT Brand (id, type) VALUES (3, 'Renault') "+
            "INSERT Brand (id, type) VALUES (4, 'Nissan') "+
            "INSERT Brand (id, type) VALUES (5, 'Peugeot') "+
            "INSERT Brand (id, type) VALUES (6, 'Ваз')";
     public void createDatabaseTables()  throws Exception{
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        statement.executeUpdate(CREATE_TYPE_TABLE);
        statement.executeUpdate(INSERT_TYPE_TABLE);
         statement.executeUpdate(CREATE_TYPE_TABLE_BRAND);
         statement.executeUpdate(INSERT_TYPE_TABLE_BRAND);

        // ... create other table
        statement.close();
    }

}
