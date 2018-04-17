package HtmlBuilder.Actions.Preview;

import Utility.FileEditing;
import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PreviewController {
    private String BuilderCode = "src/HtmlBuilder/HtmlBuilder.code";
    private FileEditing fe = new FileEditing();
    private String Code;

    @FXML
    private WebView View;

    @FXML
    public void initialize() {
        Code = fe.Import(BuilderCode);
        WebEngine engine = View.getEngine();
        engine.loadContent(Code);
    }
}