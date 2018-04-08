package Checkers.gamepices;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class Piece extends StackPane {
    private PieceType Type;

    private double Xnow;

    private double Ynow;
    private double newX;
    private double newY;

    public Piece(PieceType type, int x, int y) {
        this.Type = type;
        Move(x, y);

        Ellipse ellipse = new Ellipse(50 * 0.3125, 50 * 0.26);

        if (this.Type == PieceType.White) {
            ellipse.setFill(Color.valueOf("white"));
            ellipse.setStroke(Color.valueOf("black"));
        } else if (this.Type == PieceType.Blue) {
            ellipse.setFill(Color.valueOf("Blue"));
            ellipse.setStroke(Color.valueOf("black"));
        } else if (this.Type == PieceType.WhiteChecker) {
            ellipse.setFill(Color.valueOf("white"));
            ellipse.setStroke(Color.valueOf("gold"));
        } else {
            ellipse.setFill(Color.valueOf("Blue"));
            ellipse.setStroke(Color.valueOf("gold"));
        }

        ellipse.setStrokeWidth(50 * 0.03);

        ellipse.setTranslateX((50 - 50 * 0.3125 * 2) / 2);
        ellipse.setTranslateY((50 - 50 * 0.26 * 2) / 2);

        getChildren().add(ellipse);

        setOnMousePressed(e -> {
            newX = e.getSceneX();
            newY = e.getSceneY();
        });

        setOnMouseDragged(e -> {
            relocate(e.getSceneX() - newX + Xnow, e.getSceneY() - newY + Ynow);

        });
    }

    public void Move(int X, int Y) {
        Xnow = X * 50;
        Ynow = Y * 50;
        relocate(Xnow, Ynow);
    }

    public void CancelMove() {
        relocate(Xnow, Ynow);
    }

    public double getXnow() {
        return Xnow;
    }

    public double getYnow() {
        return Ynow;
    }

    public PieceType getType() {
        return this.Type;
    }

    public void setType(int type) {
        switch (type) {
            case -1:
                this.Type = PieceType.White;
                break;
            case -2:
                this.Type = PieceType.WhiteChecker;
                break;
            case 1:
                this.Type = PieceType.Blue;
                break;
            case 2:
                this.Type = PieceType.BlueChecker;
        }
    }
}
