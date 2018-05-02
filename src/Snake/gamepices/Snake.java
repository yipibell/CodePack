package Snake.gamepices;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import static Snake.gamepices.MoveType.none;

public class Snake extends StackPane {
    private int Length;
    private MoveType moveType;

    private int Xnow;
    private int Ynow;

    public Snake(int x, int y) {
        this.Length = 1;
        this.moveType = none;

        Move(x, y);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf("black"));
        rectangle.setHeight(15);
        rectangle.setWidth(15);

        getChildren().add(rectangle);
    }

    public void Move(int x, int y) {
        switch (moveType) {
            case Up:
                Xnow = (x) * 15;
                Ynow = (y + 1) * 15;
                relocate(Xnow, Ynow);
                break;
            case Down:
                Xnow = (x) * 15;
                Ynow = (y - 1) * 15;
                relocate(Xnow, Ynow);
                break;
            case Left:
                Xnow = (x - 1) * 15;
                Ynow = (y) * 15;
                relocate(Xnow, Ynow);
                break;
            case Right:
                Xnow = (x + 1) * 15;
                Ynow = (y) * 15;
                relocate(Xnow, Ynow);
                break;
            case none:
                Xnow = (x) * 15;
                Ynow = (y) * 15;
                relocate(Xnow, Ynow);
                break;
        }
    }

    public int getXnow() {
        return Xnow;
    }

    public int getYnow() {
        return Ynow;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public void setMoveType(MoveType moveType) {
        this.moveType = moveType;
    }
}
