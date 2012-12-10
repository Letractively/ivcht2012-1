package edu.sstu.service;

import edu.sstu.dao.FilmDBDao;
import edu.sstu.dao.FilmDao;
import edu.sstu.model.Film;

import java.util.List;

public class FilmBaseService implements FilmService {

//    private FilmDao dao = new FilmFakeDao();
    private FilmDao dao = new FilmDBDao();

    private static FilmBaseService filmBaseService;

    private FilmBaseService() {
    }

    public static FilmBaseService getInstance() {
        if (filmBaseService == null) {
            filmBaseService = new FilmBaseService();
        }
        return filmBaseService;
    }

    public List<Film> getAllFilms() {
        return dao.getAllFilms();
    }

    public List<Film> getGenreFilms(int id)
    {
        return dao.getGenreFilms(id);
    }



    public void addFilm(Film film) {
        dao.addFilm(film);
    }


 public Film editFilm(Film film) {
    return dao.editFilm(film);
   }

    public void deleteFilm(int id) {
        dao.deleteFilm(id);
    }

    public Film showFilm(int id) {
        return dao.showFilm(id);
    }
}
