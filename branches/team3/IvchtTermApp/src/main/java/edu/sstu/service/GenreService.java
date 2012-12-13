package edu.sstu.service;


import edu.sstu.model.Film;
import edu.sstu.model.Genre;

import java.util.List;

public interface GenreService {

    public List<Genre> getAllGenres();

    public void addGenre(Genre gn);

   public Film editGenre(Genre genre);

    public Film showGenre(int id);

    public void deleteGenre(int id);

}
