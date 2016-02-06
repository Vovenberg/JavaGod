package sample;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

/**
 * Created by Владимир on 01.02.2016.
 */
public class DataBase {

    Connection conn;

    public DataBase() throws ClassNotFoundException, SQLException {

        init();
    }

    private void init() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bd", "root", "йцукен");
        System.out.println("Успешное подключение");
    }

    public void Insert (String name,String surname) throws SQLException {
        Statement st1=conn.createStatement( );
        String insertTableSQL = "INSERT INTO users"
                + "(id, login, password) " + "VALUES"
                + "('"+new Random().nextInt(30)+"','"+name+"','"+surname+"')";

        st1.execute(insertTableSQL);
        conn.close();
    }
    public String SelectLogin (String login) throws SQLException {
        String str=null;
        Statement st2=conn.createStatement();
        ResultSet rs =st2.executeQuery("Select * from users where login='"+login+"'");
        while (rs.next()){
            if (rs.getString("password").equals(null))return null;
            str=rs.getString("password"); }
        conn.close();
        return str;
    }





}
