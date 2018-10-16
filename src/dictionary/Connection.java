package dictionary;

import  java.sql.*;
import  java.util.*;
public class Connection {
    public java.sql.Connection connection ;
    public java.sql.Connection getConnection(){
        String db_name = "dictionary";
        String user= "root";
        String pass ="12345678";
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
