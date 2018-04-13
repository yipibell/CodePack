package ScreenWorks.SecundScreen;

import Utility.FileEditing;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class SecundScreenController {
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label Label;
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation = "src/ScreenWorks/FirstSreen/save.txt";
    private SwichWindow swich = new SwichWindow();

    @FXML
    private void Cancel(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        Label.setText(started());
    }

    private String started() {
        return fe.ImportLine(SaveFilelocation);
    }

    @FXML
    private void Switch(ActionEvent event) throws IOException {
        swich.SwichNewWindow("/TabScreen/TadScreenFXML.fxml", event);
    }

}
