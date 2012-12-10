package edu.sstu.dao;

import edu.sstu.model.Film;
import edu.sstu.model.Genre;

import java.util.List;

public interface GenreDao {


    public List<Genre> getAllGenres();

    public void addGenre(Genre genre);

    public Film editGenre(Genre Genre);

    public Film showGenre(int id);

    public void deleteGenre(int id);


}
