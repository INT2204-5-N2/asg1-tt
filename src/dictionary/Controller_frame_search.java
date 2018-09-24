package dictionary;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

import java.sql.*;

public class Controller_frame_search {

    public TextField txt_Search;
    public Button btn_Search;
    public Button btn_AddWord;


    public void open_frame_add(ActionEvent actionEvent) throws  Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("frame//frameAdd.fxml"));
        Parent root1 = (Parent)fxmlLoader.load();

        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        stage.initStyle(StageStyle.UNDECORATED);

        stage.setTitle("Thêm từ mới");
        stage.setScene(new Scene(root1));
        stage.show();
    }
    public  void  search(ActionEvent actionEvent) throws SQLException{
        Connection connection_class = new Connection();
        java.sql.Connection conection = connection_class.getConnection();
        String sql = "Insert into vd1 values('2','"+txt_Search.getText()+"');";
        try {
            Statement statement = conection.createStatement();
            statement.executeUpdate(sql);

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
