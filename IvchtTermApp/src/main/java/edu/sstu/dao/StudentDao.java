package edu.sstu.dao;

import edu.sstu.model.Student;

import java.util.List;

public interface StudentDao {


    public List<Student> getAllStudents();

    public List<Student> getGrStudents(int id);

    public void addStudent(Student student);

    public Student editStudent(Student student);

    public Student showStudent(int id);

    public void deleteStudent(int id);


}
