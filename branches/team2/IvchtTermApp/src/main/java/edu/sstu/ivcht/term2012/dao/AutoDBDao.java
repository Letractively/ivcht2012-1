package edu.sstu.ivcht.term2012.dao;

import model.Auto;
import model.Brand;
import model.Packag;
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
    String sql="";
    public List<Auto> getAllAutos(int id, int tps) {
        List<Auto> autoList = new LinkedList<Auto>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet=null;


            if (id==0){
                if(tps>0){
                    sql="SELECT    Auto.*, Brand.brand, Types.types FROM Auto INNER JOIN Brand ON Auto.id_brand = Brand.id INNER JOIN Types ON Auto.id_types = Types.id where id_types="+tps+" order by Brand.brand";

                }
                    else
                {
                    sql="SELECT    Auto.*, Brand.brand, Types.types FROM Auto INNER JOIN Brand ON Auto.id_brand = Brand.id INNER JOIN Types ON Auto.id_types = Types.id order by Brand.brand";

                }
                     }
            else {
                  sql="SELECT    Auto.*, Brand.brand, Types.types FROM  Auto INNER JOIN Brand ON Auto.id_brand = Brand.id INNER JOIN Types ON Auto.id_types = Types.id where id_brand="+id+" order by Brand.brand";
        }
            resultSet =  statement.executeQuery(sql);
            while (resultSet.next()) {
                Auto auto = new Auto(resultSet.getInt("id"),resultSet.getInt("id_brand"), resultSet.getInt("id_types"), resultSet.getString("types"),resultSet.getInt("seat"),resultSet.getInt("height"),resultSet.getInt("width"),resultSet.getInt("len"),resultSet.getString("descr"), resultSet.getString("brand"),resultSet.getString("model"),resultSet.getDouble("price"),resultSet.getInt("rating"),resultSet.getString("datest"));

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

    @Override
    public List<Packag> getAllPackag(int id) {
        List<Packag> packageList = new LinkedList<Packag>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();

            if (id==0){

              sql="SELECT Package.*, Types.types FROM Package INNER JOIN Types ON Package.id_types = Types.id INNER JOIN Auto ON Package.id_auto=Auto.id";
            }
            else
            {
                sql="SELECT Package.*, Types.types FROM Package INNER JOIN Types ON Package.id = Types.id INNER JOIN Auto ON Package.id_auto=Auto.id where id_types="+id;
            }


            ResultSet resultSet =  statement.executeQuery(sql);
               while (resultSet.next()) {
               Packag packag= new Packag(resultSet.getInt("id"), resultSet.getInt("id_types"),resultSet.getInt("id_types"), resultSet.getString("types"), resultSet.getInt("motor"), resultSet.getString("transmission"), resultSet.getString("drive"), resultSet.getDouble("price"), resultSet.getInt("rating"), resultSet.getString("datestart"), resultSet.getInt("checked"));
               packageList.add(packag);

            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return packageList;
    }
}
