package dictionary;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import javax.swing.plaf.nimbus.State;
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
        String new_word = txt_NewWord.getText();
        String new_word_detail = txt_NewWordDetail.getText();

        String sql = "Insert into tbl_edict values('new_id','"+new_word+"','"+new_word_detail+"');";
//        String sql = "INSERT Into vd3 values ('b','hai');";
//        String sql = "Insert into tbl_edict values('"  + new_word+"','"+new_word_detail+"');";
        System.out.println(sql);
        Statement statement = conection.createStatement();
        try {
            statement.executeUpdate(sql);
            System.out.println("da them");
        }
        catch (Exception e) {
            System.out.println("da ton tai");
        }

    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
