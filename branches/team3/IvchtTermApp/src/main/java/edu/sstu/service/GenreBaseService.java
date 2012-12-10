package edu.sstu.service;

import edu.sstu.dao.GenreDBDao;
import edu.sstu.dao.GenreDao;
import edu.sstu.model.Film;
import edu.sstu.model.Genre;

import java.util.List;

public class GenreBaseService implements GenreService {


    private GenreDao dao = new GenreDBDao();

    private static GenreBaseService GenreBaseService;

    private GenreBaseService() {
    }

    public static GenreBaseService getInstance() {
        if (GenreBaseService == null) {
            GenreBaseService = new GenreBaseService();
        }
        return GenreBaseService;
    }

  /*  public List<Film> getAllStudents() {
        return dao.getAllStudents();
    }


    public void addStudent(Film student) {
        dao.addStudent(student);
    }


 public Film editStudent(Film student) {
    return dao.editStudent(student);
   }

    public void deleteStudent(int id) {
        dao.deleteStudent(id);
    }

    public Film showStudent(int id) {
        return dao.showStudent(id);
    }
       */
    public List<Genre> getAllGenres() {
        return dao.getAllGenres();
    }

    public void addGenre(Genre genre) {
        dao.addGenre(genre);
    }

    public Film editGenre(Genre Genre) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Film showGenre(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteGenre(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
