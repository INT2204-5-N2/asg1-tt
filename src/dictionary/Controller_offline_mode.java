package dictionary;

import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.*;
import java.io.*;
import java.io.IOException;
import java.sql.*;

public class Controller_offline_mode {

    private Main main;
    public TextField txt_Search;
    public Button btn_Search;
    public Button btn_AddWord;
    public WebView webView;
    public Button btn_Change;
    public Button btn_Delete;
//    public TextField lbl_Word;
    public WebView ww_Detail;
    public static String word;

    public TextField txt_WordDetail;
    public Button btn_Save;
    public Label lbl_Detail;

    public  void  search(ActionEvent actionEvent) throws SQLException{

        Connection connection_class = new Connection();
        java.sql.Connection conection = connection_class.getConnection();
        String key = txt_Search.getText();

        String sql = "SELECT detail from tbl_edict where word ='"+key+"';";
        System.out.println(sql);
        WebEngine webEngine = ww_Detail.getEngine();
        webEngine.loadContent("");
        try {
            Statement statement = conection.createStatement();

            ResultSet rs = statement.executeQuery(sql);
            int d =0;
            while ( rs.next()) {
                btn_Delete.setDisable(false);
                btn_Change.setDisable(false);
                String html = rs.getString("detail");
                html = "<html><body>" + html +"</body></html>";

                webEngine.loadContent(html);
//                System.out.println(rs.getString("detail"));
                d =1;
            }
            if (d == 0) {
                webEngine.loadContent("Chưa có dữ liệu");
            }

        }
        catch (Exception e){

            e.printStackTrace();
        }

    }
    @FXML
    private void goFrameEdit() throws IOException{
        word = txt_Search.getText();
//        System.out.println(word);

        main.showFrameEdit();

    }


    public void update_word(ActionEvent actionEvent) throws SQLException{


        try {

            Connection connection_class = new Connection();
            System.out.println("done");
            java.sql.Connection conection = connection_class.getConnection();

            System.out.println("word : "  + word);
            String new_word_detail = txt_WordDetail.getText();
            String sql = "update tbl_edict set detail ='" + new_word_detail + "' where  word ='" + word+"';";
            System.out.println(sql);
            Statement statement = conection.createStatement();
            try {
                statement.executeUpdate(sql);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Đã sửa thành công!");
                alert.showAndWait();
//                ((Node)(actionEvent.getSource())).getScene().getWindow().hide();
                txt_WordDetail.setText("");

            }
            catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText(e.toString());
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void delete_word(ActionEvent actionEvent) throws  SQLException{
        Connection connection_class = new Connection();
        java.sql.Connection conection = connection_class.getConnection();
        String key = txt_Search.getText();
        String sql = "delete from tbl_edict where word ='"+key+"';";
        System.out.println(sql);
        Statement statement = conection.createStatement();
        try {
            statement.executeUpdate(sql);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Đã xóa !");
            alert.showAndWait();
            txt_Search.setText("");
            WebEngine webEngine = ww_Detail.getEngine();
            webEngine.loadContent("");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public void read_word(ActionEvent actionEvent) throws IOException{
        String fileName = "read.vbs";
        String key = txt_Search.getText();

        try {
            // Assume default encoding.
            FileWriter fileWriter =
                    new FileWriter(fileName);

            // Always wrap FileWriter in BufferedWriter.
            BufferedWriter bufferedWriter =
                    new BufferedWriter(fileWriter);

            // Note that write() does not automatically
            // append a newline character.
            bufferedWriter.write("CreateObject(\"SAPI.SpVoice\").Speak\""+key+"\"");

            // Always close files.
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                    "Error writing to file '"
                            + fileName + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        Runtime.getRuntime().exec("wscript " + fileName);

    }
}
