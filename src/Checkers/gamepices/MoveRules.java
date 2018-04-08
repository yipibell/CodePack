package Checkers.gamepices;

public class MoveRules {
    private MoveType type;

    private Piece piece;

    public MoveRules(MoveType type, Piece piece) {
        this.type = type;
        this.piece = piece;
    }

    public MoveRules(MoveType type) {
        this.type = type;
        this.piece = null;
    }

    public MoveType getType() {
        return type;
    }

    public Piece getPiece() {
        return piece;
    }
}
