package TimerScreen;


import Utility.CommonCommands;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimerController {
    private Timeline Timeline= new Timeline();;
    private CommonCommands CC=new CommonCommands();
    private int msec=0,sec,min,hour;
    private boolean Stop=false;

    @FXML
    private AnchorPane MainScreen;

    @FXML
    private TextField Timer;

    @FXML
    private TextField LastTimer;

    @FXML
    private TextField Goal;

    @FXML
    public void initialize() {
    }

    private void timertime(){
        msec++;
        if (msec>=99){sec++;msec=0;}
        if (sec>=59){min++;sec=0;}
        if (min>=59){hour++;min=0;}
    }

    @FXML
    void Back(javafx.event.ActionEvent event) throws IOException {
        Stage stage = (Stage) MainScreen.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Alarmer");
        stage.setScene(scene);
    }

    private String TimerAsString(int num){
        String AsString="";
        if(num<10){AsString="0"+num;}else {AsString=""+num;}
        return AsString;
    }

    public void Play(ActionEvent actionEvent) {
        KeyFrame frame=new KeyFrame(Duration.seconds(0.01));
        int Stoper=314712000;
        if (Timeline.getStatus().equals(Animation.Status.STOPPED)){
            if (CC.SetNum(Goal.getText())!=0){Stoper=CC.SetNum(Goal.getText())*100;}
            Timeline.setCycleCount(Stoper);
            Timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(0.01), event -> {
                timertime();
                Timer.setText(TimerAsString(hour)+":"+TimerAsString(min)+":"+TimerAsString(sec)+"."+TimerAsString(msec));
            }));
            Timeline.play();
            Timeline.setOnFinished(e -> {Timeline.getKeyFrames().clear();});
        }
            else if(Timeline.getStatus().equals(Animation.Status.PAUSED)){Timeline.play();}
        else {
            Timeline.stop();
            LastTimer.setText(TimerAsString(hour)+":"+TimerAsString(min)+":"+TimerAsString(sec)+"."+TimerAsString(msec));
            Timeline.getKeyFrames().clear();
            Stoper=314712000;
        }
    }

    public void Clear(ActionEvent actionEvent) {
        Timeline.stop();
        Timeline.getKeyFrames().clear();
        msec=sec=min=hour=0;
        Timer.setText(TimerAsString(hour)+":"+TimerAsString(min)+":"+TimerAsString(sec)+"."+TimerAsString(msec));
        LastTimer.setText("");
        Goal.setText("");
    }
}