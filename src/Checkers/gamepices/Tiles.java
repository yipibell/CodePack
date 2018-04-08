package Checkers.gamepices;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Tiles extends Rectangle {

    private Piece piece;

    public Tiles(boolean color, int x, int y) {
        setWidth(50);
        setHeight(50);

        relocate(x * 50, y * 50);
        setFill(color ? Color.valueOf("Aquamarine") : Color.valueOf("White"));
    }


    public boolean Contains() {
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
