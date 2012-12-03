package edu.sstu.service;

import edu.sstu.dao.StudentDBDao;
import edu.sstu.dao.StudentDao;
import edu.sstu.model.Student;

import java.util.List;

public class StudentBaseService implements StudentService {

//    private StudentDao dao = new StudentFakeDao();
    private StudentDao dao = new StudentDBDao();

    private static StudentBaseService studentBaseService;

    private StudentBaseService() {
    }

    public static StudentBaseService getInstance() {
        if (studentBaseService == null) {
            studentBaseService = new StudentBaseService();
        }
        return studentBaseService;
    }

    public List<Student> getAllStudents() {
        return dao.getAllStudents();
    }

    public List<Student> getGrStudents(int id)
    {
        return dao.getGrStudents(id);
    }

    public double getAverageHeight() {
        List<Student> studentList = dao.getAllStudents();
        int sum = 0;
        int count = studentList.size();
        for (Student student : studentList) {
            sum += student.getHeight();
        }
        if (count == 0) return 0;
        return sum / (double) count;
    }

    public void addStudent(Student student) {
        dao.addStudent(student);
    }


 public Student editStudent(Student student) {
    return dao.editStudent(student);
   }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }

    public Student showStudent(int id) {
        return dao.showStudent(id);
    }
}
