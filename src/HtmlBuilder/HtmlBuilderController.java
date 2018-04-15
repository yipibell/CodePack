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
import javafx.scene.web.HTMLEditor;
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
    private HTMLEditor Code;

    @FXML
    private TextArea HtmlCode;

    @FXML
    public void initialize() {
        NewFile(new ActionEvent());
    }


    @FXML
    void NewFile(ActionEvent event) {
        Chosen = null;
        HtmlCode.setText(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "  <head>\n" +
                        "    <meta charset=\"utf-8\">\n" +
                        "    <title></title>\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "\n" +
                        "  </body>\n" +
                        "</html>");
        Code.setHtmlText("<!DOCTYPE html>\n" +
                "<html>\n" +
                "  <head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <title></title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "\n" +
                "  </body>\n" +
                "</html>");
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
                Code.setHtmlText(html);
                GenCode(event);
            } else {
                System.out.println("That is a wrong format file");
            }
        }
    }

    @FXML
    void save(ActionEvent event) {
        if (Chosen == null) {
            saveAs(event);
        } else {
            fe.export(Chosen.getAbsolutePath(), HtmlCode.getText());
        }
    }

    @FXML
    void saveAs(ActionEvent event) {
        fe.export(BuilderCode, HtmlCode.getText());
        open.LoadNewWindow("/HtmlBuilder/Actions/SaveAs/Save.fxml", "Save as?", new Stage());
    }

    @FXML
    void Close(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }

    @FXML
    public void GenCode(ActionEvent actionEvent) {
        HtmlCode.setText(Code.getHtmlText());
    }

    @FXML
    public void GenText(ActionEvent actionEvent) {
        if (HtmlCode.getText() != null) Code.setHtmlText(HtmlCode.getText());
    }

    @FXML
    public void delete(ActionEvent event) {
    }

    @FXML
    void about(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/Utility/About/About.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }
}