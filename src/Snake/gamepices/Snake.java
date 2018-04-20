package Snake.gamepices;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

public class Snake extends StackPane {
    private SnakeType Type;
    private int Length;

    private double Xnow;
    private double Ynow;
    private double newX;
    private double newY;

    public Snake(SnakeType type, int x, int y) {
        this.Type = type;
        this.Length = 1;
        Move(x, y);

        Rectangle rectangle = new Rectangle();
        rectangle.setFill(Paint.valueOf("black"));
        rectangle.setHeight(15);
        rectangle.setWidth(15);

        getChildren().add(rectangle);
    }

    public void Move(int X, int Y) {
        Xnow = (X + 1) * 15;
        Ynow = (Y + 1) * 15;
        relocate(Xnow, Ynow);
    }

    public double getXnow() {
        return Xnow;
    }

    public double getYnow() {
        return Ynow;
    }

    public SnakeType getType() {
        return this.Type;
    }

}
