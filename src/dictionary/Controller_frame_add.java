package dictionary;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.sql.*;
import java.util.*;

public class Controller_frame_add {
    public TextField txt_NewWord;
    public TextField txt_NewWordDetail;
    public Button btn_Add;

    public void addWord(ActionEvent actionEvent) throws SQLException{
    try {
        Connection connection_class = new Connection();
        System.out.println("done");
        java.sql.Connection conection = connection_class.getConnection();
        String sql = "Insert into vd2 values('1','"+txt_NewWord.getText()+"','"+txt_NewWordDetail.getText()+"');";
//        String sql = "INSERT Into vd2 values ('1','2','3');";
        Statement statement = conection.createStatement();
        statement.executeUpdate(sql);

    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
