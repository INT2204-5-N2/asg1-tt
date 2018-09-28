package dictionary;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("frame//frameSearch.fxml"));
        primaryStage.setTitle("Dictionary by TT");
        primaryStage.setScene(new Scene(root, 780, 560));
        try {
            Connection connection_class = new Connection();
            java.sql.Connection conection = connection_class.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
