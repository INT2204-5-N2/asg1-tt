package dictionary;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javafx.event.ActionEvent;

import java.awt.*;
import java.io.IOException;


public class Main extends Application {
    private Stage primaryStage;
    private static BorderPane mainLayout;
    public Label lbl_Detail;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Dictionary by TT");
        showMainView();
        showOfflineMode();
        showButton();
    }
    private void showMainView() throws IOException{
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
    public static void showCredit() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/credit.fxml"));
        BorderPane credit = loader.load();
        mainLayout.setCenter(credit);
    }
    private void showButton() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/button.fxml"));
        BorderPane button = loader.load();
        mainLayout.setLeft(button);
    }

    public static void showOfflineMode() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/offline_mode.fxml"));
        BorderPane offlineMode = loader.load();
        mainLayout.setCenter(offlineMode);
    }
    public static void showOnlineMode() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/online_mode.fxml"));
        BorderPane onlineMode = loader.load();
        mainLayout.setCenter(onlineMode);
    }
    public static void showFrameAdd() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/frameAdd.fxml"));
        BorderPane frameAdd = loader.load();
        mainLayout.setCenter(frameAdd);
    }
    public static void showFrameEdit() throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("frame/frameEdit.fxml"));
        BorderPane frameEdit = loader.load();
        mainLayout.setCenter(frameEdit);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
