package HtmlBuilder;

import Utility.CommonCommands;
import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HtmlBuilderController {
    private FileEditing fe = new FileEditing();
    private OpenNewWindow open = new OpenNewWindow();
    private CommonCommands CC = new CommonCommands();
    private String BuilderCode = "src/HtmlBuilder/HtmlBuilder.code";
    private File Chosen;

    @FXML
    private BorderPane Main;

    @FXML
    private TextArea Code;


    /*help*/

    /*file*/

    @FXML
    void about(ActionEvent event) {

    }

    @FXML
    void NewFile(ActionEvent event) {

    }

    @FXML
    void open(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Chosen = fc.showOpenDialog(null);

        if (Chosen == null) {
            fe.ErrorExport("1");
            open.LoadNewWindow(("/Utility/Error/Error.fxml"), "Error", null);
        } else {
            if (CC.getFileType(Chosen).equalsIgnoreCase("html")) {
                String html = fe.Import(Chosen.getAbsolutePath());
                Code.setText(html);
            } else {
                System.out.println("That is a wrong format file");
            }
        }
    }

    @FXML
    void save(ActionEvent event) {
        if (Chosen == null) {
        } else {
            fe.export(Chosen.getAbsolutePath(), Code.getText());
        }
    }

    @FXML
    void saveAs(ActionEvent event) {
        fe.export(BuilderCode, Code.getText());
        open.LoadNewWindow("/HtmlBuilder/Actions/Save.fxml", "Save as?", new Stage());
    }

    @FXML
    void Close(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }

    /*edit*/

    @FXML
    public void delete(ActionEvent event) {
    }
}