package edu.sstu.ivcht.term2012.dao;

import model.Auto;
import model.Brand;
import model.Types;

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
            ResultSet resultSet =  statement.executeQuery("SELECT    Auto.model, Brand.brand, Auto.id_brand, Auto.seat, Auto.len, Auto.width, Auto.height, Auto.descr, Auto.id\n" +
                    "FROM         Auto INNER JOIN Brand ON Auto.id_brand = Brand.id order by Brand.brand");
            while (resultSet.next()) {
                Auto auto = new Auto(resultSet.getInt("id"),resultSet.getInt("id_brand"),resultSet.getInt("seat"),resultSet.getInt("height"),resultSet.getInt("width"),resultSet.getInt("len"),resultSet.getString("descr"), resultSet.getString("brand"),resultSet.getString("model"));
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

    @Override
    public List<Types> getAllTypes() {
        List<Types> typesList = new LinkedList<Types>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM Types");
            while (resultSet.next()) {
                Types types = new Types(resultSet.getInt("id"),resultSet.getString("types"));
                typesList.add(types);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return typesList;
    }
}
