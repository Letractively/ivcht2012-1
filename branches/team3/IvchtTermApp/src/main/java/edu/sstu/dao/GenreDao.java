package edu.sstu.dao;

import edu.sstu.model.Genre;

import java.util.List;

public interface GenreDao {


    public List<Genre> getAllGenres();

    public void addGenre(Genre gn);

    public Genre editGenre(Genre gn);

    public Genre showGenre(int id);

    public void deleteGenre(int id);


}
