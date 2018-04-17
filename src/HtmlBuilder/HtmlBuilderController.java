package HtmlBuilder;

import Utility.CommonCommands;
import Utility.ErrorAlart;
import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
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
    private TreeView TreeMenu;

    @FXML
    public void initialize() {
        NewFile(new ActionEvent());
        TreeMenuStarter();
    }

    @FXML
    void NewFile(ActionEvent event) {
        Chosen = null;
        HtmlCode.setText(
                "<!DOCTYPE html>\n" +
                        "<html>\n" +
                        "  <head>\n" +
                        "    <title>\n" +
                        "    </title>\n" +
                        "  </head>\n" +
                        "  <body>\n" +
                        "\n" +
                        "  </body>\n" +
                        "</html>");
        Code.setHtmlText("");
    }

    @FXML
    void open(ActionEvent event) {
        FileChooser fc = new FileChooser();
        Chosen = fc.showOpenDialog(null);

        if (Chosen == null) {
            new ErrorAlart(1);
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
        if (CC.Checker(HtmlCode.getText(), Code.getHtmlText(), ">+ ")) {
            if (Chosen == null) {
                saveAs(event);
            } else {
                fe.export(Chosen.getAbsolutePath(), HtmlCode.getText());
            }
        } else {
            new ErrorAlart(8);
        }
    }

    @FXML
    void saveAs(ActionEvent event) {
        if (CC.Checker(HtmlCode.getText(), Code.getHtmlText(), ">+ ")) {
            fe.export(BuilderCode, HtmlCode.getText());
            open.LoadNewWindow("/HtmlBuilder/Actions/SaveAs/Save.fxml", "Save as?", new Stage());
        } else {
            new ErrorAlart(8);
        }

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
    public void preview(ActionEvent event) {
        if (CC.Checker(HtmlCode.getText(), Code.getHtmlText(), ">+ ")) {
            fe.export(BuilderCode, HtmlCode.getText());
            open.LoadNewWindow("/HtmlBuilder/Actions/Preview/Preview.fxml", "Preview of youre Code", null);
        } else {
            new ErrorAlart(8);
        }
    }

    @FXML
    void about(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/Utility/About/About.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }


    private void TreeMenuStarter() {
        TreeItem<String> rootItem = new TreeItem<>("Add");
        rootItem.setExpanded(true);

        TreeItem<String> AddImage = new TreeItem<>("Image");
        TreeItem<String> AddLink = new TreeItem<>("Link");

        rootItem.getChildren().addAll(AddImage, AddLink);
        TreeMenu.setRoot(rootItem);
        Main.setLeft(TreeMenu);
    }

    public void TreeMenuOnMouseClick(MouseEvent event) {
        if (event.getClickCount() == 2) {
            TreeItem<String> selected = (TreeItem<String>) TreeMenu.getSelectionModel().getSelectedItem();
            switch (selected.getValue()) {
                case "Image":
                    open.LoadNewWindow("/HtmlBuilder/Actions/CodeLibrary/AddImage/AddImage.fxml", "Add Image", null);
                    break;
                case "Link":
                    open.LoadNewWindow("/HtmlBuilder/Actions/CodeLibrary/AddLink/AddLink.fxml", "Add Link", null);
                    break;
                default:
                    break;
            }
        }
    }

}