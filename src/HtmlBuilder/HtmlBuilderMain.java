package HtmlBuilder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class HtmlBuilderMain extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/HtmlBuilder/HtmlBuilder.fxml"));
        primaryStage.setTitle("Html Builder");
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.show();
    }

}
