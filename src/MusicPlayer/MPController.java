package MusicPlayer;


import MusicPlayer.MusicFile.MusicFile;
import MusicPlayer.MusicFile.MusicFileList;
import Utility.CommonCommands;
import Utility.FileEditing;
import Utility.OpenNewWindow;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import static javafx.scene.media.MediaPlayer.Status.PLAYING;

public class MPController {
    @FXML
    private AnchorPane MainScreen;

    @FXML
    private ListView<String> MP3List;

    @FXML
    private static CheckBox repeat;

    /*List*/
    private ObservableList<String> MFObservableList = FXCollections.observableArrayList();
    private MusicFileList MFL=new MusicFileList();

    /*initialize*/

    @FXML
    public void initialize() {
        ListLoad();
    }

    private void ListLoad(){
        MFL.LoadMFList();
        for (MusicFile mf:MFL.getMFList()){
            MFObservableList.add(mf.getMusicFileName());
        }
        MP3List.setItems(MFObservableList);
        MP3List.refresh();
    }

    /*Actions*/
    private FileEditing fe = new FileEditing();
    private String ErrorFilelocation = "Java/src/Utility/Error/Error.txt";
    private OpenNewWindow open = new OpenNewWindow();
    private CommonCommands CC=new CommonCommands();
    private static MediaPlayer mediaPlayer;
    private int playingindex=-1;

    @FXML
    void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) MainScreen.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Alarmer");
        stage.setScene(scene);
    }

    @FXML
    void Play(ActionEvent event) {
        repeating();
        if (playingindex<0){playingindex=0;}
        if (mediaPlayer!=null&&mediaPlayer.getStatus().equals(PLAYING)){mediaPlayer.stop();}
        else{
            playingindex=MP3List.getSelectionModel().getSelectedIndex();
            mediaPlayer = new MediaPlayer(new Media(new File(MFL.getMFList().get(playingindex).getMusicFileLocation()).toURI().toString()));
            mediaPlayer.play();
        }
    }

    @FXML
    void PlayNext(ActionEvent event) {
        repeating();
        if (mediaPlayer!=null&&mediaPlayer.getStatus().equals(PLAYING)){mediaPlayer.stop();}
        if (playingindex+1>MFL.getMFList().size()-1){playingindex=0;}
        else {playingindex++;}
        mediaPlayer = new MediaPlayer(new Media(new File(MFL.getMFList().get(playingindex).getMusicFileLocation()).toURI().toString()));
        mediaPlayer.play();
    }

    @FXML
    void SelectMP3(ActionEvent event) {
        FileChooser fc = new FileChooser();
        File Chosen = fc.showOpenDialog(null);
        if (Chosen == null) {
            fe.export(ErrorFilelocation, "1");
            open.LoadNewWindow(("/Utility/Error/Error.fxml"), "Error", null);
        } else {
            if (CC.getFileType(Chosen).equalsIgnoreCase("mp3")) {
                MFObservableList.add(Chosen.getName().substring(Chosen.getName().lastIndexOf('/')+1));
                MFL.AddMusicFile(new MusicFile(Chosen.getPath(),Chosen.getName().substring(Chosen.getName().lastIndexOf('/')+1)));
                MFL.SaveMFList();
            } else {
                System.out.println("Thet is a wrong format file");
            }
        }
    }

    public void ReName(ActionEvent actionEvent) {
        if (SelectChecker(MP3List.getSelectionModel().getSelectedItem())) {
            MFL.SaveMF(MFL.getMFList().get(MP3List.getSelectionModel().getSelectedIndex()),MP3List.getSelectionModel().getSelectedIndex() );
            Stage stage = (Stage) (MainScreen.getScene().getWindow());
            open.LoadNewWindow("/MusicPlayer/Actions/ReName.fxml","ReName",null);
        }
    }

    public void Remove(ActionEvent actionEvent) {
        if (SelectChecker(MP3List.getSelectionModel().getSelectedItem())) {
            MFL.LoadMFList();
            MFL.getMFList().remove(MP3List.getSelectionModel().getSelectedIndex());
            MFObservableList.remove(MP3List.getSelectionModel().getSelectedItem());
            MFL.SaveMFList();
            MP3List.refresh();
        }
    }

    private boolean SelectChecker(Object obj) {
        boolean valid;
        if (obj == null) {
            fe.export(ErrorFilelocation, "4");
            open.LoadNewWindow(("/Utility/Error/Error.fxml"), "Error", null);
            valid = false;
        } else {
            valid = true;
        }
        return valid;
    }

    private static void repeating(){
        if (repeat.isSelected()){
            mediaPlayer.setCycleCount(1000);}
    }

}