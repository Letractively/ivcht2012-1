package edu.sstu.service;

import edu.sstu.dao.GruppaDBDao;
import edu.sstu.dao.GruppaDao;
import edu.sstu.model.Gruppa;
import edu.sstu.model.Student;

import java.util.List;

public class GruppaBaseService implements GruppaService {


    private GruppaDao dao = new GruppaDBDao();

    private static GruppaBaseService GruppaBaseService;

    private GruppaBaseService() {
    }

    public static GruppaBaseService getInstance() {
        if (GruppaBaseService == null) {
            GruppaBaseService = new GruppaBaseService();
        }
        return GruppaBaseService;
    }

  /*  public List<Student> getAllStudents() {
        return dao.getAllStudents();
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
       */
    public List<Gruppa> getAllGrupps() {
        return dao.getAllGrupps();
    }

    public void addGruppa(Gruppa gruppa) {
        dao.addGruppa(gruppa);
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
}
