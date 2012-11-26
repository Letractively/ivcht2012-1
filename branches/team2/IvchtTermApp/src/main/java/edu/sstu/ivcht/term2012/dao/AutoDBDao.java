package edu.sstu.ivcht.term2012.dao;

import model.Auto;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:42
 * To change this template use File | Settings | File Templates.
 */
public class AutoDBDao implements AutoDao{

    public List<Auto> getAllAutos() {
        List<Auto> autoList = new LinkedList<Auto>();
        return autoList;
    }

    public void addAuto(Auto auto) {

    }

    public void editAuto(Auto auto) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public void deleteAuto(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Auto readAuto(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
