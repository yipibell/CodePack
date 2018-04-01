package ScreenWorks.FirstSreen;

import Utility.OpenNewWindow;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class FirstScreenController {
    private OpenNewWindow open = new OpenNewWindow();
    private SwichWindow swich = new SwichWindow();

    @FXML
    public void Open(ActionEvent actionEvent) {
        open.LoadNewWindow("/ScreenWorks/SecundScreen/SecondScreenFXML.fxml", "2nd", null);
    }

    @FXML
    private void Switch(ActionEvent event) throws IOException {
        swich.SwichNewWindow("/ScreenWorks/ThirdScreen/ThirdScreenFXML.fxml", event);
    }
}
