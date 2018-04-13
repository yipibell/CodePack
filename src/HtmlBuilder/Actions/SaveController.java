package HtmlBuilder.Actions;

import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class SaveController {
    private String BuilderCode = "src/HtmlBuilder/HtmlBuilder.code";
    private String ErrorFilelocation = "src/Utility/Error/Error.txt";
    private OpenNewWindow open = new OpenNewWindow();
    private FileEditing fe = new FileEditing();
    private File dir;
    private String Code;
    @FXML
    private AnchorPane Main;

    @FXML
    private TextField Location;

    @FXML
    private TextField Name;

    @FXML
    public void initialize() {
        Code = fe.ImportLine(BuilderCode);
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Where do you want to save that page?");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        dir = directoryChooser.showDialog(new Stage());
        if (dir != null) Location.setText(dir.getAbsolutePath());
    }

    @FXML
    void Browse(ActionEvent event) {
        Stage stage = (Stage) (Main.getScene().getWindow());
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Where do you want to save that page?");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        dir = directoryChooser.showDialog(stage);
        Location.setText(dir.getAbsolutePath());
    }

    @FXML
    void Save(ActionEvent event) {
        if (!Location.getText().equalsIgnoreCase("")) {
            fe.export(Location.getText() + Name.getText() + ".html", Code);
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.close();
        } else {
            fe.ErrorExport("1");
            open.LoadNewWindow(("/Utility/Error/Error.fxml"), "Error", null);
        }
    }
}