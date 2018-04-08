package Checkers;


import Checkers.gamepices.*;
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

public class CheckersController {

    @FXML
    private BorderPane Main;

    @FXML
    private Pane field;
    private Group tiles = new Group();
    private Group pieces = new Group();
    private Tiles[][] board = new Tiles[8][8];
    private Piece lastpiece;

    @FXML
    private void Back(javafx.event.ActionEvent event) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/MainScreen/MainScreen.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Main");
        stage.setScene(scene);
    }

    @FXML
    public void initialize() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Tiles tile = new Tiles((x + y) % 2 != 0, x, y);
                board[x][y] = tile;
                tiles.getChildren().add(tile);
                Piece piece = null;
                if (y <= 2 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.Blue, x, y);
                }


                if (y >= 5 && (x + y) % 2 != 0) {
                    piece = makePiece(PieceType.White, x, y);
                }

                if (piece != null) {
                    tile.setPiece(piece);
                    pieces.getChildren().add(piece);
                }
            }
        }

        field.getChildren().addAll(tiles, pieces);
    }

    private Piece makePiece(PieceType type, int x, int y) {
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

            switch (result.getType()) {
                case none:
                    piece.CancelMove();
                    break;
                case move:
                    piece.Move(newX, newY);
                    if (newY == 7 || newY == 0) {
                        piece.setType(typeInt(piece.getType()) * 2);
                    }
                    board[x0][y0].setPiece(null);
                    board[newX][newY].setPiece(piece);
                    break;
                case kill:
                    piece.Move(newX, newY);
                    if (newY == 7 || newY == 0) {
                        piece.setType(typeInt(piece.getType()) * 2);
                    }
                    board[x0][y0].setPiece(null);
                    board[newX][newY].setPiece(piece);

                    Piece deadPiece = result.getPiece();
                    board[BoardPix(deadPiece.getXnow())][BoardPix(deadPiece.getYnow())].setPiece(null);
                    pieces.getChildren().remove(deadPiece);
                    break;
            }

        });
        return piece;
    }

    private int BoardPix(double pixel) {
        return (int) (pixel + 50 / 2) / 50;
    }

    private MoveRules tryMove(Piece piece, int newX, int newY) {
        if (board[newX][newY].Contains() || (newX + newY) % 2 == 0) {
            return new MoveRules(MoveType.none);
        }

        if (lastpiece != null) {
            if (typeInt(lastpiece.getType()) * typeInt(piece.getType()) > 0) {
                return new MoveRules(MoveType.none);
            }
        }
        int x0 = BoardPix(piece.getXnow());
        int y0 = BoardPix(piece.getYnow());

        if (piece.getType() == PieceType.White || piece.getType() == PieceType.Blue) {
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
        } else if (piece.getType() == PieceType.WhiteChecker || piece.getType() == PieceType.BlueChecker) {
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
    }

    public int typeInt(PieceType type) {
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
    }

    public void restart(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) Main.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getResource("/Checkers/Checkers.fxml"));
        Scene scene = new Scene(parent);
        stage.setTitle("Checkers");
        stage.setScene(scene);
    }
}