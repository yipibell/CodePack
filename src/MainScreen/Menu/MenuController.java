package MainScreen.Menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private VBox Menu;

    @FXML
    public void Close(ActionEvent event) {
        Stage stage = (Stage) Menu.getScene().getWindow();
        stage.close();
    }

    @FXML
    void ScreenWork(ActionEvent event) {
        SwichToScreen("/ScreenWorks/FirstSreen/FirstScreen.fxml", "ScreenWork");
    }

    @FXML
    void TabScreen(ActionEvent event) {
        SwichToScreen("/TabScreen/TadScreenFXML.fxml", "TabScreen");
    }

    @FXML
    void EncryptionScreen(ActionEvent event) {
        SwichToScreen("/EncryptionScreen/EncryptionScreen.fxml", "EncryptionScreen");
    }

    @FXML
    void CalculatorScreen(ActionEvent event) {
        SwichToScreen("/CalculatorScreen/Calculator.fxml", "Calculator");
    }


    @FXML
    void ClockScreen(ActionEvent event) {
        SwichToScreen("/ClockScreen/Clock.fxml", "Clock");
    }

    @FXML
    void Cheacker(ActionEvent event) {
        SwichToScreen("/Checkers/Checkers.fxml", "Clock");
    }

    @FXML
    void TimerScreen(ActionEvent event) {
        SwichToScreen("/TimerScreen/Timer.fxml", "Timer");
    }

    @FXML
    void HtmlBuilderScreen(ActionEvent event) {
        SwichToScreen("/HtmlBuilder/HtmlBuilder.fxml", "Html Builder");
    }


    @FXML
    void MPScreen(ActionEvent event) {
        SwichToScreen("/MusicPlayer/MP.fxml", "Music Move");
    }

    private void SwichToScreen(String Path, String ScreenName) {
        try {
            Stage stage = (Stage) Menu.getScene().getWindow();
            Parent parent = FXMLLoader.load(getClass().getResource(Path));
            Scene scene = new Scene(parent);
            stage.setTitle(ScreenName);
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}