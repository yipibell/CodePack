package Snake;


import Snake.gamepices.Snake;
import Snake.gamepices.SnakeType;
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
    private Group pieces = new Group();
    private Tiles[][] board = new Tiles[36][24];
    private Snake lastpiece;

    @FXML
    private void Back(ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }

    @FXML
    public void initialize() {
        SetTiles();

        field.getChildren().addAll(tiles, pieces);
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

    private Snake makeSnake(SnakeType type, int x, int y) {
        Snake snake = new Snake(type, x, y);

        return snake;
    }
/*    private Piece makePiece(SnakeType type, int x, int y) {
        Piece piece = new Piece(type, x, y);

        piece.setOnMouseReleased(e -> {
            int newX = BoardPix(piece.getLayoutX());
            int newY = BoardPix(piece.getLayoutY());

            MoveRules result;

            if (newX < 0 || newY < 0 || newX >= 8 || newY >= 8) {
                result = new MoveRules(MoveType.none);
            } else {
                result = tryMove(piece, newX, newY);
            }
            int x0 = BoardPix(piece.getXnow());
            int y0 = BoardPix(piece.getYnow());
            Piece Checker;
            switch (result.getType()) {
                case none:
                    piece.CancelMove();
                    break;
                case move:
                    if (newY == 7 || newY == 0) {
                        piece.setType(typeInt(piece.getType()) * 2);
                        Checker = makePiece(piece.getType(), newX, newY);
                        pieces.getChildren().add(Checker);
                        board[newX][newY].setPiece(Checker);
                        board[BoardPix(piece.getXnow())][BoardPix(piece.getYnow())].setPiece(null);
                        pieces.getChildren().remove(piece);
                    } else {
                        piece.Move(newX, newY);
                        board[x0][y0].setPiece(null);
                        board[newX][newY].setPiece(piece);
                    }
                    break;
                case kill:
                    piece.Move(newX, newY);
                    if (newY == 7 || newY == 0) {
                        piece.setType(typeInt(piece.getType()) * 2);
                        makePiece(piece.getType(), x, y);
                        board[BoardPix(piece.getXnow())][BoardPix(piece.getYnow())].setPiece(null);
                        pieces.getChildren().remove(piece);
                        board[newX][newY].setPiece(makePiece(piece.getType(), x, y));
                    } else {
                        board[x0][y0].setPiece(null);
                        board[newX][newY].setPiece(piece);
                    }

                    Piece deadPiece = result.getPiece();
                    board[BoardPix(deadPiece.getXnow())][BoardPix(deadPiece.getYnow())].setPiece(null);
                    pieces.getChildren().remove(deadPiece);

                    if (board[newX + 1][newY + 1].Contains() && !board[newX + 2][newY + 2].Contains() ||
                            board[newX - 1][newY + 1].Contains() && !board[newX - 2][newY + 2].Contains() ||
                            board[newX + 1][newY - 1].Contains() && !board[newX + 2][newY - 2].Contains() ||
                            board[newX - 1][newY - 1].Contains() && !board[newX - 2][newY - 2].Contains()) {
                        lastpiece.setType(typeInt(lastpiece.getType()) * -1);

                    }
                    break;
            }

        });
        return piece;
    }*/

    private int BoardPix(double pixel) {
        return (int) (pixel + 15 / 2) / 15;
    }

    /*private MoveRules tryMove(Piece piece, int newX, int newY) {
        if (lastpiece != null) {
            if (typeInt(lastpiece.getType()) * typeInt(piece.getType()) > 0) {
                return new MoveRules(MoveType.none);
            }
            if (board[newX + 1][newY + 1].Contains() && !board[newX + 2][newY + 2].Contains() ||
                    board[newX - 1][newY + 1].Contains() && !board[newX - 2][newY + 2].Contains() ||
                    board[newX + 1][newY - 1].Contains() && !board[newX + 2][newY - 2].Contains() ||
                    board[newX - 1][newY - 1].Contains() && !board[newX - 2][newY - 2].Contains()) {
                lastpiece.setType(typeInt(lastpiece.getType()) * -1);

            }
        }

        if (board[newX][newY].Contains() || (newX + newY) % 2 == 0) {
            return new MoveRules(MoveType.none);
        }

        int x0 = BoardPix(piece.getXnow());
        int y0 = BoardPix(piece.getYnow());

        if (piece.getType() == SnakeType.White || piece.getType() == SnakeType.Blue) {
            if (Math.abs(newX - x0) == 1 && newY - y0 == piece.getType().moveDir) {
                lastpiece = piece;
                return new MoveRules(MoveType.move);
            } else if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getType().moveDir * 2) {

                int x1 = x0 + (newX - x0) / 2;
                int y1 = y0 + (newY - y0) / 2;

                if (board[x1][y1].Contains() && Math.abs(typeInt(board[x1][y1].getPiece().getType()) + typeInt(piece.getType())) < 2) {
                    lastpiece = piece;
                    return new MoveRules(MoveType.kill, board[x1][y1].getPiece());
                }
            } else if (Math.abs(newX - x0) == 2 && newY - y0 == piece.getType().moveDir * -2) {
                int x1 = x0 + (newX - x0) / 2;
                int y1 = y0 + (newY - y0) / 2;

                if (board[x1][y1].Contains() && Math.abs(typeInt(board[x1][y1].getPiece().getType()) + typeInt(piece.getType())) < 2) {
                    lastpiece = piece;
                    return new MoveRules(MoveType.kill, board[x1][y1].getPiece());
                }
            }
        } else if (piece.getType() == SnakeType.WhiteChecker || piece.getType() == SnakeType.BlueChecker) {
            if (Math.abs(newX - x0) == 1) {
                lastpiece = piece;
                return new MoveRules(MoveType.move);
            } else if (Math.abs(newX - x0) == 2) {

                int x1 = x0 + (newX - x0) / 2;
                int y1 = y0 + (newY - y0) / 2;

                if (board[x1][y1].Contains() && Math.abs(typeInt(board[x1][y1].getPiece().getType()) + typeInt(piece.getType())) < 2) {
                    lastpiece = piece;
                    return new MoveRules(MoveType.kill, board[x1][y1].getPiece());
                }
            }
        }

        return new MoveRules(MoveType.none);
    }*/

/*    public int typeInt(SnakeType type) {
        int intType = 0;
        switch (type) {
            case White:
                intType = -1;
                break;
            case WhiteChecker:
                intType = -2;
                break;
            case Blue:
                intType = 1;
                break;
            case BlueChecker:
                intType = 2;
                break;
        }
        return intType;
    }*/

    /*Actions*/
    public void restart(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/Snake/Snake.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Checkers");
        stage.setScene(scene);
    }

    public void UndoLestMove() {

    }
}