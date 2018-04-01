package TabScreen;

import TabScreen.Login.Login;
import TabScreen.Login.LoginList;
import Utility.OpenNewWindow;
import Utility.SwichWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class TadScreenController {
    private SwichWindow swich = new SwichWindow();
    private OpenNewWindow open = new OpenNewWindow();
    private LoginList loginlist = new LoginList();
    private ObservableList<Login> LoginObservableList = FXCollections.observableArrayList();

    @FXML
    private BorderPane rootPane;
    @FXML
    private TableView<Login> Tab;
    @FXML
    private TableColumn<Login, String> UserName;
    @FXML
    private TableColumn<Login, String> PassWord;
    @FXML
    private TableColumn<Login, String> SiteURL;
    @FXML
    private TableColumn Select = new TableColumn("Check");

    @FXML
    private void Cancel(ActionEvent event) {
        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        swich.SwichNewWindow("/ScreenWorks/SecundScreen/SecondScreenFXML.fxml", event);
    }

    @FXML
    private void Add(ActionEvent event) throws IOException {
        open.LoadNewWindow("/TabScreen/Login/AddLogin/AddLoginFxml.fxml", "Add Login", null);
    }

    public void initialize() {

        ColumnSet();
        loadData();
    }

    private void ColumnSet() {
        UserName.setCellValueFactory(new PropertyValueFactory<>("UserName"));
        PassWord.setCellValueFactory(new PropertyValueFactory<>("PassWord"));
        SiteURL.setCellValueFactory(new PropertyValueFactory<>("SiteURL"));
        Select.setCellValueFactory(new PropertyValueFactory<>("Check"));

    }

    private void loadData() {
        LoginObservableList.clear();
        loginlist.LoadLogins();
        for (Login log : loginlist.getLoginList()) {
            LoginObservableList.add(log);
        }
        Tab.setItems(LoginObservableList);
    }

    public void Refresh(ActionEvent event) throws IOException {
        swich.SwichNewWindow("/TabScreen/TadScreenFXML.fxml", event);
    }
}
