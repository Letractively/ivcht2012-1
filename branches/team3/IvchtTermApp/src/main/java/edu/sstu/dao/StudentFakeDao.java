package edu.sstu.dao;

import edu.sstu.model.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

public class StudentFakeDao implements StudentDao {
    private List<Student> studentList = new LinkedList<Student>();

    public StudentFakeDao() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        try {
            studentList.add( new Student(1, "Иван", "Иванов", sdf.parse("12.04.1995"), 170, 1));
            studentList.add( new Student(2, "Петр", "Петров", sdf.parse("15.08.1992"), 184, 2));
            studentList.add( new Student(3, "Марина", "Маринина", sdf.parse("23.01.1990"), 165, 2));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        return studentList;
    }

    public List<Student> getGrStudents(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Student editStudent(Student student) {
        for (Student st: studentList){
            if (st.getId() ==  student.getId()){
                st.setFirstName(student.getFirstName());
                st.setSecondName(student.getSecondName());
                st.setBirthday(student.getBirthday());
                st.setHeight(student.getHeight());
                break;
            }
        }
        return student;
    }

    public void deleteStudent(int id) {
        for (Student st: studentList){
            if (st.getId() ==  id){
                studentList.remove(st);
                break;
            }
        }
    }
    public Student showStudent(int id) {
        for (Student st: studentList){
            if (st.getId() ==  id){
                studentList.remove(st);
                break;
            }
        }
        return null;
    }
}
