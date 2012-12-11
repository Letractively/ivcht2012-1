package edu.sstu.ivcht.term2012.dao;

import model.*;
import model.Types;

import java.sql.*;
import java.text.SimpleDateFormat;
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

    public AutoDBDao() {
        //To change body of created methods use File | Settings | File Templates.
    }

            public void getAuto(int id_auto){

            }
            public void getPackage(int id_package){

            }
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
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            // Statement statement = connection.createStatement();
            String sql="select  max(id) as id1 from Auto";

            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.next();
            int tab_id=resultSet.getInt("id1")+1;

          sql = "INSERT INTO Auto (id, id_brand,id_types, seat, height, width, len, descr, model, price, rating, datest) VALUES "+
                    "("+tab_id+",?,?,?, ?,?,?,?,?,?,?,'2010-01-01')";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, auto.getId_brand());
            pstm.setInt(2, auto.getId_types());
            pstm.setInt(3, auto.getSeat());
            pstm.setInt(4, auto.getHeight());
            pstm.setInt(5, auto.getWidth());
            pstm.setInt(6, auto.getLen());
            pstm.setString(7, auto.getDescr());
            pstm.setString(8, auto.getModel());
            pstm.setDouble(9, auto.getPrice());
            pstm.setInt(10, auto.getRating());
           //statement.executeUpdate(sql);
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void editAuto(Auto auto) {
        //To change body of implemented methods use File | Settings | File Templates.
    }


    public void deleteAuto(int id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Auto readAuto(int id) {
        Auto auto=null;
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            sql="SELECT    Auto.*, Brand.brand, Types.types FROM Auto INNER JOIN Brand ON Auto.id_brand = Brand.id INNER JOIN Types ON Auto.id_types = Types.id where id="+id;
            ResultSet resultSet =  statement.executeQuery(sql);
            resultSet.next();
            auto= new Auto(resultSet.getInt("id"),resultSet.getInt("id_brand"), resultSet.getInt("id_types"), resultSet.getString("types"),resultSet.getInt("seat"),resultSet.getInt("height"),resultSet.getInt("width"),resultSet.getInt("len"),resultSet.getString("descr"), resultSet.getString("brand"),resultSet.getString("model"),resultSet.getDouble("price"),resultSet.getInt("rating"),resultSet.getString("datest"));
            resultSet.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return auto;  //To change body of implemented methods use File | Settings | File Templates.
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
                sql="SELECT Package.*, Types.types FROM Package INNER JOIN Types ON Package.id_types = Types.id INNER JOIN Auto ON Package.id_auto=Auto.id where id_auto="+id;
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

    @Override
    public void addPackage(Packag packag) {

        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
           // Statement statement = connection.createStatement();
            String sql="select  max(id) as id1 from Package";

            ResultSet resultSet=statement.executeQuery(sql);
            resultSet.next();
            int tab_id=resultSet.getInt("id1")+1;

             sql = "INSERT INTO Package (id, id_types,id_auto, motor, transmission, drive, price, rating, datestart,checked) VALUES "+
                    "("+tab_id+",1,"+packag.getId_auto()+",?, ?,?,?,0,'2010-01-01',?)";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, packag.getMotor());
            pstm.setNString(2,String.valueOf(packag.getTransmission()));
            pstm.setNString(3, String.valueOf(packag.getDrive()));
            pstm.setDouble(4, packag.getPrice());
            pstm.setInt(5,packag.getChecked());


            //statement.executeUpdate(sql);
            pstm.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

         }

              public void addUser(Usr usr){
                  try {
                      Connection connection =  DataBaseConnection.getConnection();
                      Statement statement = connection.createStatement();
                      // Statement statement = connection.createStatement();
                      String sql="select  max(user_id) as id1 from users ";
                      ResultSet resultSet=statement.executeQuery(sql);
                      resultSet.next();
                      int tab_id=resultSet.getInt("id1")+1;

                      sql = "INSERT INTO users (user_id, user_login , user_password,user_hash,user_ip ,prava) VALUES "+
                              "("+tab_id+",?,?, 0,0,?)";
                      PreparedStatement pstm = connection.prepareStatement(sql);
                      pstm.setString(1, usr.getUser_name());
                      pstm.setString(2, usr.getUser_pass());
                      pstm.setInt(3, usr.getPrava());
                      pstm.executeUpdate();

                  } catch (Exception e) {
                      e.printStackTrace();
                  }
              }
    public void deleteUser(int id){

    }
    public List<Usr> getAllUser() {
        List<Usr> userList = new LinkedList<Usr>();
        try {
            Connection connection =  DataBaseConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultS =  statement.executeQuery("SELECT * FROM users");
            while (resultS.next()) {
                Usr users = new Usr(resultS.getInt("user_id"),resultS.getString("user_login"),resultS.getString("user_password"),resultS.getString("user_hash"),resultS.getString("user_ip"),resultS.getInt("prava"));
                userList.add(users);
            }
            resultS.close();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userList;
    }
}
