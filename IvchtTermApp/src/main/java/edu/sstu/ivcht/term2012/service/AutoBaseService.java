package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.dao.AutoDBDao;
import edu.sstu.ivcht.term2012.dao.AutoDao;
import model.*;
import sun.awt.image.PixelConverter;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public class AutoBaseService implements AutoService {

    private AutoDao dao = new AutoDBDao();

    private static AutoBaseService autoBaseService;

    private AutoBaseService() {
    }

    public static AutoBaseService getInstance() {
        if (autoBaseService == null) {
            autoBaseService = new AutoBaseService();
        }
        return autoBaseService;
    }

    public List<Auto> getAllAutos(int id, Integer tps) {
        return dao.getAllAutos(id, tps);
    }
    public List<Brand> getAllBrand() {
        return dao.getAllBrand();
    }


    public List<Types> getAllTypes() {
        return dao.getAllTypes();  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addAuto(Auto auto) {
        dao.addAuto(auto);
    }

    public void editAuto(Auto auto) {
        dao.editAuto(auto);
    }

    public void deleteAuto(int id) {
        dao.deleteAuto(id);
    }
    public Auto readAuto(int id) {
        return  dao.readAuto(id);
    }


    public List<Packag> getAllPackag(int id) {
        return dao.getAllPackag(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addPackage(Packag packag){
        dao.addPackage(packag);
    }
    public void addUser(Usr usr){
        dao.addUser(usr);
    }
    public void deleteUser(int id){
        dao.deleteUser(id);
    }
    public List<Usr> getAllUser() {
        return dao.getAllUser();
    }
}
