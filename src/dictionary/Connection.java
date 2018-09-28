package dictionary;

import  java.sql.*;
import  java.util.*;
public class Connection {
    public java.sql.Connection connection ;
    public java.sql.Connection getConnection(){
        String db_name = "edictv2";
        String user= "root";
        String pass = "root";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/"+db_name+"?autoReconnect=true&useSSL=false",user,pass);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }
}
