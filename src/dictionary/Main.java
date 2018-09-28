package dictionary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.swing.*;
import javafx.event.*;
import java.io.*;
import java.sql.SQLException;

public class Main extends Application {
    private Stage primaryStage;
    private BorderPane mainLayout;
    public Button offline_mode;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dictionary by TT");
        showMainView();
        showCredit();
    }
    public void showMainView() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/mainFrame.fxml"));
        mainLayout = loader.load();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        try {
            Connection connection_class = new Connection();
            java.sql.Connection conection = connection_class.getConnection();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        primaryStage.show();
    }
    public void showCredit() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/credit.fxml"));
        BorderPane credit = loader.load();
        mainLayout.setCenter(credit);
    }

    public void showOfflineMode(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/offline_mode.fxml"));
        BorderPane offlineMode = loader.load();
        mainLayout.setCenter(offlineMode);

    }


    public static void main(String[] args) {
        launch(args);
    }
}
