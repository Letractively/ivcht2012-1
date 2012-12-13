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


    public List<Genre> getAllGenres() {
        return dao.getAllGenres();
    }

    public void addGenre(Genre gn) {
        dao.addGenre(gn);
    }

    public Film editGenre(Genre genre) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public Film showGenre(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void deleteGenre(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
