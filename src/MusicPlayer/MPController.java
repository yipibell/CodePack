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
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MPController {
    @FXML
    private AnchorPane MainScreen;

    @FXML
    private ListView<String> MP3List;

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
    }

    /*Actions*/
    private FileEditing fe = new FileEditing();
    private String ErrorFilelocation = "Java/src/Utility/Error/Error.txt";
    private OpenNewWindow open = new OpenNewWindow();
    private CommonCommands CC=new CommonCommands();

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

    }

    @FXML
    void PlayNext(ActionEvent event) {

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

    @FXML
    private void RCMenuDelete(ActionEvent actionEvent) throws IOException {
    }

}