package Counter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class CounterController {
    private int CallCount;
    private LocalTime Break;

    @FXML
    private Label CallCounter;

    @FXML
    private Label BreakCounter;

    @FXML
    private TextField CallsToAdd;

    @FXML
    private TextField BreakToAdd;

    @FXML
    void Add1Call(ActionEvent event) {
        CallCount++;
    }

    @FXML
    void Break(ActionEvent event) {
        Timeline Timeline = new Timeline();
        Timeline.setCycleCount(1000000);
        Timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), e -> {
            Break.plusSeconds(1);
            System.out.println(Break);
            BreakCounter.setText(Break.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }));
        if (Timeline.getStatus().equals(Animation.Status.RUNNING)) {
            Timeline.stop();
        } else {
            Timeline.play();
        }
    }

    @FXML
    void AddBreaks(ActionEvent event) {

    }

    @FXML
    void AddMultipalCalls(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        CallCount = 0;
        Break = LocalTime.of(0, 0);
        CallCounter.setText("" + CallCount);
        BreakCounter.setText(Break.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
    }
}