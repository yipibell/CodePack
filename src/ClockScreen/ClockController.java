package ClockScreen;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClockController {
    private Timeline Timeline;

    @FXML
    private AnchorPane MainScreen;

    @FXML
    private Text Time;

    @FXML
    private Text Date;

    @FXML
    private Text Day;

    @FXML
    private Text AsString;

    @FXML
    public void initialize() {
        Timeline = new Timeline();
        Timeline.setCycleCount(31471200);
        Timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
            LocalDateTime Time = LocalDateTime.now();
            this.Time.setText("" + Time.format(DateTimeFormatter.ofPattern("HH:mm:ss a")));
            String Date = "";
            Date = "" + Time.getDayOfMonth() + "." + (Time.getMonthValue()) + "(" + Time.getMonth() + ")." +
                    Time.getYear();
            this.Date.setText(Date);
            Day.setText("" + Time.getDayOfWeek());
            AsString.setText("" + Time.format(DateTimeFormatter.ofPattern("YYYY:MM:dd:HH:mm")));
        }));
        Timeline.play();
    }


    @FXML
    void Back(javafx.event.ActionEvent event) throws IOException {
        Stage stage = (Stage) MainScreen.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Alarmer");
        stage.setScene(scene);
    }


}