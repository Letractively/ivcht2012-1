package edu.sstu.ivcht.term2012.service;

import java.util.List;
import model.Auto;

/**
 * Created with IntelliJ IDEA.
 * User: roman
 * Date: 23.11.12
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
public interface AutoService {
    public List<Auto> getAllAutos();

    public void addAuto(Auto auto);

    public void editAuto(Auto auto);

    public void deleteAuto(int id);

    public Auto readAuto(int id);




}
