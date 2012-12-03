package edu.sstu.service;


import edu.sstu.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public List<Student> getGrStudents(int id);

    public double getAverageHeight();

    public void addStudent(Student student);

   public Student editStudent(Student student);

    public Student showStudent(int id);

    public void deleteStudent(int id);


}
