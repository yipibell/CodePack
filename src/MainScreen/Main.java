package MainScreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage MainStage;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(root);
        MainStage = stage;
        MainStage.setScene(scene);
        MainStage.setTitle("EncryptionScreenMain");
        MainStage.show();
    }
}
