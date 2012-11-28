package edu.sstu.ivcht.term2012.dao;

import model.Auto;
import model.Brand;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM autos");
            while (resultSet.next()) {
                Auto auto = new Auto(resultSet.getInt("id"),resultSet.getInt("seat"),resultSet.getInt("height"),resultSet.getInt("width"),resultSet.getInt("len"),resultSet.getString("descr"));
                autoList.add(auto);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }



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

    @Override
    public List<Brand> getAllBrand() {
        List<Brand> brandList = new LinkedList<Brand>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Brand");
            while (resultSet.next()) {
                Brand brand = new Brand(resultSet.getInt("id"),resultSet.getString("brand"));
                brandList.add(brand);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return brandList; //To change body of implemented methods use File | Settings | File Templates.
    }
}
