package Checkers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CheckersMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Checkers/Checkers.fxml"));
        primaryStage.setTitle("Checkers");
        primaryStage.setScene(new Scene(root, 400, 425));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}
