package edu.sstu.dao;

import edu.sstu.model.Film;

import java.util.List;

public interface FilmDao {


    public List<Film> getAllFilms();

    public List<Film> getGenreFilms(int id);

    public void addFilm(Film film);

    public Film editFilm(Film film);

    public Film showFilm(int id);

    public void deleteFilm(int id);


}
