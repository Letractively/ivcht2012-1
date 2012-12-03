package edu.sstu.dao;

import edu.sstu.model.Student;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
* @author dkinzel
*/
public class StudentDBDao implements StudentDao{
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    public List<Student> getAllStudents() {
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
                        resultSet.getInt("height"),
                        resultSet.getInt("grId")
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

    public List<Student> getGrStudents(int id) {
        List<Student> studentList = new LinkedList<Student>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM students where grId=" + id);
            while (resultSet.next()) {
                Student student = new Student(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("secondName"),
                        (resultSet.getDate("birthday")),
                        resultSet.getInt("height"),
                        resultSet.getInt("grId")
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



    public void addStudent(Student student) {
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Connection connection =  DataBaseConnection.getConnection();

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO students (firstName, secondName, birthday, height, grId) VALUES ( ?, ?, ?, ?, ?)");
            pstmt.setString(1, student.getFirstName());
            pstmt.setString(2, student.getSecondName());
            pstmt.setDate(3, Date.valueOf(sdf.format(student.getBirthday())));
            pstmt.setInt(4, student.getHeight());
            pstmt.setInt(5, student.getGrId());

//            Statement statement = connection.createStatement();
//            String sql = "INSERT INTO students (firstName, secondName, birthday, height, grId) VALUES (" +
//                    "'" + student.getFirstName() + "', " +
//                    "'" + student.getSecondName() + "', " +
//                    "'" + sdf.format(student.getBirthday()) + "', " +
//                    student.getHeight()  + " , " +
//                    student.getGrId()  +
//                    ")";
//            statement.executeUpdate(sql);
//            statement.close();
            pstmt.executeUpdate();
            pstmt.close();
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
           student.setGrId(resultSet.getInt("grId"));
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
			"', Birthday='" + sdf.format(student.getBirthday()) + "', Height='" + student.getHeight()+ student.getGrId() +"' where id=" + student.getId();

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
}
}