package TabScreen.Login.AddLogin;

import TabScreen.Login.Login;
import TabScreen.Login.LoginList;
import TabScreen.TadScreenController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class AddLoginController {
    private LoginList loginlist = new LoginList();
    @FXML
    private AnchorPane AddLoginPane;
    @FXML
    private TextField UserName;
    @FXML
    private TextField PassWord;
    @FXML
    private TextField SiteURL;
    @FXML
    private Button Close;

    @FXML
    public void Cancel(ActionEvent actionEvent) {
        Stage stage = (Stage) AddLoginPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void Add(ActionEvent actionEvent) throws IOException {
        loginlist.LoadLogins();
        loginlist.AddLogin(new Login(UserName.getText(), PassWord.getText(), SiteURL.getText()));
        loginlist.SaveLogins();
        RefrashList(actionEvent);
        Close.fire();
    }

    private void RefrashList(ActionEvent event) throws IOException {
        TadScreenController tab = new TadScreenController();
        tab.Refresh(event);
    }
}
