package edu.sstu.dao;

import edu.sstu.model.Gruppa;
import edu.sstu.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
* @author dkinzel
*/
public class GruppaDBDao implements GruppaDao{


    public List<Gruppa> getAllGrupps() {
        List<Gruppa> gruppaList = new LinkedList<Gruppa>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM gruppa");
            while (resultSet.next()) {
                Gruppa gruppa = new Gruppa(
                        resultSet.getInt("id"),
                        resultSet.getString("namegrupp"),
                        resultSet.getString("info")

                );
                gruppaList.add(gruppa);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gruppaList;
          }

    public void addGruppa(Gruppa gruppa) {
        try {

            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO gruppa (namegrupp, info) VALUES (" +
                    "'" + gruppa.getnamegrupp() + "', " +
                    "'" + gruppa.getinfo() + "')";

            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student editGruppa(Gruppa Gruppa) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Student showGruppa(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteGruppa(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    /*  private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
public List<Student> getAllGrupps() {
    List<Student> studentList = new LinkedList<Student>();
    try {
        Connection connection =  DataBaseConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet =  statement.executeQuery("SELECT * FROM students");
        while (resultSet.next()) {
            Student student = new Student(
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
public void addStudent(Student student)      try {
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


public Student showStudent(int id) {
   // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Student student = new Student();
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

public Student editStudent(Student student) {
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