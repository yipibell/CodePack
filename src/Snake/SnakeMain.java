package Snake;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SnakeMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Snake/Snake.fxml"));
        primaryStage.setTitle("Snake");
        primaryStage.setScene(new Scene(root, 540, 385));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}
