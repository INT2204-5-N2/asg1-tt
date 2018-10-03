package dictionary;

import javafx.application.Platform;
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

        String sql = "Insert into tbl_edict values(0,'"+new_word+"','"+new_word_detail+"');";
//        String sql = "INSERT Into vd3 values ('b','hai');";
//        String sql = "Insert into tbl_edict values('"  + new_word+"','"+new_word_detail+"');";
        System.out.println(sql);
        Statement statement = conection.createStatement();
        try {
            statement.executeUpdate(sql);
//            System.out.println("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Đã thêm !");
            alert.showAndWait();
            txt_NewWord.setText("");
            txt_NewWordDetail.setText("");
            // ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
        }
        catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Đã tồn tại !");
            alert.showAndWait();
            txt_NewWord.setText("");
            txt_NewWordDetail.setText("");
        }

    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
