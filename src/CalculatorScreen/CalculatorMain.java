package CalculatorScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalculatorMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/CalculatorScreen/Calculator.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.setScene(new Scene(root, 400, 600));
        primaryStage.show();
    }

}
