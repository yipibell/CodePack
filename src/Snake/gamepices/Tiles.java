package Snake.gamepices;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Tiles extends Rectangle {

    private Snake piece;

    public Tiles(boolean color, int x, int y) {
        setWidth(15);
        setHeight(15);
        relocate(x * 15, y * 15);

        if (!color) {
            setFill(Paint.valueOf("Blue"));
        } else {
            setFill(Paint.valueOf("white"));
        }
    }

    public boolean Contains() {
        return piece != null;
    }

    public Snake getPiece() {
        return piece;
    }

    public void setPiece(Snake piece) {
        this.piece = piece;
    }
}
