package edu.sstu.utils;


import edu.sstu.service.*;

public class ServiceInstancer {

    public static StudentService getStudentService(){
        return StudentBaseService.getInstance();
    }
    public static GruppaService getGruppaService(){
        return GruppaBaseService.getInstance();
    }

//    public static FilmService getFilmService(){
//        return FilmBaseService.getInstance();
//    }
//    public static GenreService getGenreService(){
//        return GenreBaseService.getInstance();
//    }


}
