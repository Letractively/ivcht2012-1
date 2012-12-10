package edu.sstu.ivcht.term2012.dao;

import model.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 */
public interface AutoDao {

    public List<Auto> getAllAutos(int id, int tps);

    public void addAuto(Auto auto);

    public void editAuto(Auto auto);

    public void deleteAuto(int id);

    public Auto readAuto(int id);

    public List<Brand> getAllBrand();

    public List<Types> getAllTypes();

    public List<Packag> getAllPackag(int id);

    public void addPackage(Packag packag);

    void addUser(Usr usr);

    void deleteUser(int id);

    public List<Usr> getAllUser();
}
