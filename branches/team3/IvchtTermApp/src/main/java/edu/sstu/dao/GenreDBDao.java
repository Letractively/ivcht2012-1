package edu.sstu.dao;

import edu.sstu.model.Genre;
import edu.sstu.model.Film;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
* @author dkinzel
*/
public class GenreDBDao implements GenreDao {


    public List<Genre> getAllGenres() {
        List<Genre> genreList = new LinkedList<Genre>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM genres");
            while (resultSet.next()) {
                Genre genre = new Genre(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("info"),
                        resultSet.getString("text")

                );
                genreList.add(genre);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genreList;
          }

    public void addGenre(Genre gn) {
        try {

            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO genres (name, info, text) VALUES (" +
                    "'" + gn.getName() + "', " +
                    "'" + gn.getInfo() + "', " +
                    "'" + gn.getText() + "')";
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Film editGenre(Genre Genre) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Film showGenre(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteGenre(int id) {

            try {
                Connection connection =  DataBaseConnection.getConnection();
                Statement statement = connection.createStatement();
                String sql = "delete from genres where id="+id;
                statement.executeUpdate(sql);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }


    /*  private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
public List<Film> getAllGrupps() {
    List<Film> studentList = new LinkedList<Film>();
    try {
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM students");
        while (resultSet.next()) {
            Film student = new Film(
                    resultSet.getInt("id"),
                    resultSet.getString("firstName"),
                    resultSet.getString("secondName"),
                    (resultSet.getDate("birthday")),
                    resultSet.getInt("height")
            );
            studentList.add(student);
       }
        resultSet.close();
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return studentList;
}
/*
public void addStudent(Film student)      try {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "INSERT INTO students (firstName, secondName, birthday, height) VALUES (" +
                "'" + student.getFirstName() + "', " +
                "'" + student.getSecondName() + "', " +
                "'" + sdf.format(student.getBirthday()) + "', " +
                student.getHeight()  +
                ")";

        statement.executeUpdate(sql);

    } catch (Exception e) {
        e.printStackTrace();
    }
}


public Film showStudent(int id) {
   // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Film student = new Film();
    try {
        Connection connection = DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "SELECT * FROM students where id=" + id;

       //String sql2 = "SELECT COUNT(*) FROM students  where id=" + id;
      ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
         // ResultSet resultSet2 = statement.executeQuery(sql2);
          student.setId(resultSet.getInt("id"));
       student.setFirstName(resultSet.getString("firstName"));
       student.setSecondName(resultSet.getString("secondName"));
       student.setBirthday(resultSet.getDate("birthday"));
       student.setHeight(resultSet.getInt("height"));
       resultSet.close();
       statement.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return student;
}

public Film editStudent(Film student) {
    try {
       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "UPDATE students SET FirstName='"+student.getFirstName()+"', secondName='" + student.getSecondName() +
        "', Birthday='" + sdf.format(student.getBirthday()) + "', Height='" + student.getHeight()+"' where id=" + student.getId();

        statement.executeUpdate(sql);
        statement.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return student;
}

public void deleteStudent(int id) {
    try {
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        String sql = "delete from students where id="+id;

        statement.executeUpdate(sql);

    } catch (Exception e) {
        e.printStackTrace();
    }
}      */
}