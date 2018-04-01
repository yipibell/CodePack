package MusicPlayer.Actions;


import MusicPlayer.MusicFile.MusicFile;
import MusicPlayer.MusicFile.MusicFileList;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ReNameController {

    @FXML
    private TextField NewName;

    @FXML
    private TextField OldName;

    /*Starter Method*/
    private SwichWindow swich = new SwichWindow();
    private MusicFileList MFL = new MusicFileList();
    private MusicFile mf;
    @FXML
    public void initialize() {
        loadMF();
    }

    private void loadMF() {
        mf = MFL.LoadMF();
       OldName.setText(mf.getMusicFileName());
    }


    /*Actions*/

    @FXML
    void Back(ActionEvent event) {
        try {swich.SwichNewWindow("/MusicPlayer/MP.fxml",event);}
        catch (IOException e) {e.printStackTrace();}
    }

    @FXML
    void Chenge(ActionEvent event) {
        if (NewName.getText().isEmpty()){NewName.setText("UnNamed");}
        MFL.LoadMFList();
        MFL.getMFList().get(MFL.getIndex()).setMusicFileName(NewName.getText());
        MFL.SaveMFList();
        try {swich.SwichNewWindow("/MusicPlayer/MP.fxml",event);}
        catch (IOException e) {e.printStackTrace();}
    }
}