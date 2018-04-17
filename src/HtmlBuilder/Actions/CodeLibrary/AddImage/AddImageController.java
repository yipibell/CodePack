package HtmlBuilder.Actions.CodeLibrary.AddImage;

import Utility.CommonCommands;
import Utility.ErrorAlart;
import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class AddImageController {
    private CommonCommands CC = new CommonCommands();
    private OpenNewWindow open = new OpenNewWindow();
    private FileEditing fe = new FileEditing();
    private File file;

    @FXML
    private AnchorPane Main;

    @FXML
    private TextField Location;

    @FXML
    void Browse(ActionEvent event) {
        Stage stage = (Stage) (Main.getScene().getWindow());
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Where do you want to save that page?");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        file = fileChooser.showOpenDialog(stage);
        if (file == null) {
            new ErrorAlart(1);
        } else {
            Location.setText(file.getPath());
        }
    }

    @FXML
    void GetCode(ActionEvent event) {
        CommonCommands.copy("<img src=" + Location.getText() + ">");
        Close(event);
    }

    @FXML
    void Close(ActionEvent event) {
        Stage stage = (Stage) Main.getScene().getWindow();
        stage.close();
    }
}