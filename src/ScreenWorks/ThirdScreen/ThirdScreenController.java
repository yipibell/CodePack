package ScreenWorks.ThirdScreen;

import Utility.FileEditing;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ThirdScreenController {

    @FXML
    private TextField Line;
    @FXML
    private AnchorPane rootPane;
    private SwichWindow swich = new SwichWindow();
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation = "src/ScreenWorks/EncryptionScreenMain/save.txt";

    @FXML
    private void goBack(ActionEvent event) throws IOException {
        swich.SwichNewWindow("/ScreenWorks/FirstSreen/FirstScreen.fxml", event);
    }

    @FXML
    private void Add(ActionEvent event) {
        String line = Line.getText();
        fe.export(SaveFilelocation, line);
    }
}