package Snake;

import Snake.gamepices.Snake;
import Snake.gamepices.Tiles;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeController {

    @FXML
    private BorderPane Main;

    @FXML
    private Pane field;
    private Group tiles = new Group();
    private Group snake = new Group();
    private Tiles[][] board = new Tiles[36][24];
    private Snake lastpiece;

    @FXML
    public void initialize() {
        SetTiles();
        snake.getChildren().add(makeSnake(10, 10));
        field.getChildren().addAll(tiles, snake);
    }

    private void SetTiles() {
        for (int y = 0; y < 24; y++) {
            for (int x = 0; x < 36; x++) {
                Tiles tile = new Tiles(Color(x, y), x, y);
                board[x][y] = tile;
                tiles.getChildren().add(tile);
            }
        }
    }

    private Boolean Color(int x, int y) {
        return x != 0 && x != 35 && y != 0 && y != 23;
    }

    private Snake makeSnake(int x, int y) {
        Snake snake = new Snake(x, y);
        /*snake.setOnKeyReleased(event -> {
            int newX = BoardPix(snake.getLayoutX());
            int newY = BoardPix(snake.getLayoutY());

            System.out.println(event.getCode());
            switch (event.getCode()){
                case KP_UP:
                    snake.setMoveType(MoveType.Up);
                    snake.Move(snake.getXnow(),snake.getYnow());
                    break;
                case KP_DOWN:
                    snake.setMoveType(MoveType.Down);
                    snake.Move(snake.getXnow(),snake.getYnow());
                    break;
                case KP_LEFT:
                    snake.setMoveType(MoveType.Left);
                    snake.Move(snake.getXnow(),snake.getYnow());
                    break;
                case KP_RIGHT:
                    snake.setMoveType(MoveType.Right);
                    snake.Move(snake.getXnow(),snake.getYnow());
                    break;
                default:
                    break;
            }

        });*/
        return snake;
    }

    private int BoardPix(double pixel) {
        return (int) (pixel + 15 / 2) / 15;
    }

    /*Actions*/

    public void restart(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/Snake/Snake.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Snake");
        stage.setScene(scene);
    }

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }
}