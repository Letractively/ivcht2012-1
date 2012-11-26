package edu.sstu.ivcht.term2012.service;

import edu.sstu.ivcht.term2012.dao.AutoDBDao;
import edu.sstu.ivcht.term2012.dao.AutoDao;
import model.Auto;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public class AutoBaseService {

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

    public List<Auto> getAllAutos() {
        return dao.getAllAutos();
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

}
