package edu.sstu.service;


import edu.sstu.model.Genre;
import edu.sstu.model.Gruppa;
import edu.sstu.model.Student;

import java.util.List;

public interface GenreService {

    public List<Genre> getAllGenres();

    public void addGenre(Genre genre);

   public Student editGenre(Genre genre);

    public Student showGenre(int id);

    public void deleteGenre(int id);

}
