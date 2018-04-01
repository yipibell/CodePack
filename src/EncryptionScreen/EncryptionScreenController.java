package EncryptionScreen;

import Utility.Encryption;
import Utility.FileEditing;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EncryptionScreenController {
    private SwichWindow swich = new SwichWindow();
    private String SecretKey = "Login";
    private Encryption encryption;
    private FileEditing fe = new FileEditing();
    private String SaveFilelocation = "src/EncryptionScreen/XXX.info";

    @FXML
    private TextField Input;

    @FXML
    private TextField Encrypt;

    @FXML
    private TextField Decrypt;

    @FXML
    private void On(ActionEvent event) throws Exception {
        byte[] save = encryption.Encryption(Input.getText(), SecretKey);
        fe.SavebitFile(save, SaveFilelocation);
        Encrypt.setText(""+save);
        byte[] Load = fe.LoadbitFile(SaveFilelocation);
        Load = encryption.Decryption(Load, SecretKey);
        String sDecrypt = new String(Load);
        Decrypt.setText(sDecrypt);
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        swich.SwichNewWindow("/MainScreen/MainScreen.fxml", actionEvent);

    }
}

