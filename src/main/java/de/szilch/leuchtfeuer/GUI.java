package de.szilch.leuchtfeuer;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ResourceBundle;

public class GUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        ResourceBundle bundle = ResourceBundle.getBundle("UIResources");
        Parent root = FXMLLoader.load(getClass().getResource("mainframe.fxml"), bundle);
        primaryStage.setTitle(getFrameTitle());
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private String getFrameTitle() {
        ResourceBundle bundle = ResourceBundle.getBundle("UIResources");
        return  bundle.getString("global.appname") + " v" + bundle.getString("global.version");
    }


    public static void start() {
        launch(new String[]{});
    }
}
