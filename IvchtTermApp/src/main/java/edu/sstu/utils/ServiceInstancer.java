package edu.sstu.utils;


import edu.sstu.service.*;

public class ServiceInstancer {

    public static FilmService getFilmService(){
        return FilmBaseService.getInstance();
    }
    public static GenreService getGenreService(){
        return GenreBaseService.getInstance();
    }




}
