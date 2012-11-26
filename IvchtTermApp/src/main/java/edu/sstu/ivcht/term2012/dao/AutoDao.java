package edu.sstu.ivcht.term2012.dao;

import model.Auto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public interface AutoDao {
    public List<Auto> getAllAutos();

    public void addAuto(Auto auto);

    public void editAuto(Auto auto);

    public void deleteAuto(int id);

    public Auto readAuto(int id);
}
