package EncryptionScreen;

import Utility.Encryption;
import Utility.FileEditing;
import Utility.SwichWindow;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    private void On(ActionEvent event) {
        byte[] save = Encryption.Encryption(Input.getText(), SecretKey);
        fe.SavebitFile(save, SaveFilelocation);
        Encrypt.setText("" + save);
        byte[] Load = fe.LoadbitFile(SaveFilelocation);
        Load = Encryption.Decryption(Load, SecretKey);
        String sDecrypt = new String(Load);
        Decrypt.setText(sDecrypt);
    }

    public void Back(ActionEvent actionEvent) throws IOException {
        swich.SwichNewWindow("/MainScreen/MainScreen.fxml", actionEvent);

    }
}

