package Checkers;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.io.IOException;

public class CheckersController {

    @FXML
    private BorderPane Main;

    @FXML
    private GridPane field;

    @FXML
    private TextFlow history;

    @FXML
    private TextField move;

    @FXML
    void Back(javafx.event.ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }


}