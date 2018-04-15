package HtmlBuilder.Actions.SaveAs;

import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;

public class SaveController {
    private String BuilderCode = "src/HtmlBuilder/HtmlBuilder.code";
    private OpenNewWindow open = new OpenNewWindow();
    private FileEditing fe = new FileEditing();
    private File dir;
    private String Code;
    @FXML
    private AnchorPane Main;

    @FXML
    private TextField Location;

    @FXML
    private Spinner<String> FileType;

    @FXML
    private TextField Name;

    @FXML
    public void initialize() {
        setFileTypes();
        Code = fe.ImportLine(BuilderCode);
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Where do you want to save that page?");
        directoryChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        dir = directoryChooser.showDialog(new Stage());
        if (dir != null) Location.setText(dir.getAbsolutePath());
    }

    private void setFileTypes() {
        ObservableList<String> ft = FXCollections.observableArrayList("html", "txt", "css");
        FileType.setValueFactory(new SpinnerValueFactory.ListSpinnerValueFactory<String>(ft));
        FileType.getValueFactory().setValue("txt");
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
            fe.export(Location.getText() + "/" + Name.getText() + "." + FileType.getEditor().getText(), Code);
            Stage stage = (Stage) Main.getScene().getWindow();
            stage.close();
        } else {
            fe.ErrorExport("1");
            open.LoadNewWindow(("/Utility/Error/Error.fxml"), "Error", null);
        }
    }
}