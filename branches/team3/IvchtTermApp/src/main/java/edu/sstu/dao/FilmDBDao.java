package edu.sstu.dao;

import edu.sstu.model.Film;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
* @author dkinzel
*/
public class FilmDBDao implements FilmDao {
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    public List<Film> getAllFilms() {
        List<Film> filmList = new LinkedList<Film>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM films");
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("info"),
                        resultSet.getString("country"),
                        resultSet.getBoolean("d3"),
                        resultSet.getDate("date"),
                        resultSet.getInt("genreId")
                );
                filmList.add(film);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }

    public List<Film> getGenreFilms(int id) {
        List<Film> filmList = new LinkedList<Film>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM films where genreId=" + id);
            while (resultSet.next()) {
                Film film = new Film(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("info"),
                        resultSet.getString("country"),
                        resultSet.getBoolean("d3"),
                        resultSet.getDate("date"),
                        resultSet.getInt("genreId")
                );
                filmList.add(film);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filmList;
    }



    public void addFilm(Film film) {
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Connection connection =  DataBaseConnection.getConnection();

            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO films (name, info, country, D3, date, genreId) VALUES ( ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, film.getName());
            pstmt.setString(2, film.getInfo());
            pstmt.setString(3, film.getCountry());
            pstmt.setBoolean(4, film.getD3());
            pstmt.setDate(5, Date.valueOf(sdf.format(film.getDate())));
            pstmt.setInt(6, film.getGenreId());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Film showFilm(int id) {

        Film film = new Film();
        try {
            Connection connection = DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM films where id=" + id;


          ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();

              film.setId(resultSet.getInt("id"));
           film.setName(resultSet.getString("name"));
           film.setInfo(resultSet.getString("info"));
           film.setCountry(resultSet.getString("country"));
           film.setD3(resultSet.getBoolean("d3"));
           film.setDate(resultSet.getDate("date"));
           film.setGenreId(resultSet.getInt("genreId"));
           resultSet.close();
           statement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return film;
    }










    public Film editFilm(Film film) {
        try {
           SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "UPDATE films SET name='"+ film.getName()+"', info='" + film.getInfo() + "', country='" + film.getCountry() + "', d3='" + film.getD3() +
			"', Date='" + sdf.format(film.getDate()) + film.getGenreId() + "' where id=" + film.getId();
            statement.executeUpdate(sql);
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return film;
    }

    public void deleteFilm(int id) {
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            String sql = "delete from films where id="+id;
            statement.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
}
}