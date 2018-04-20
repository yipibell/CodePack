package Snake.gamepices;

public class MoveRules {
    private MoveType type;

    private Snake piece;

    public MoveRules(MoveType type, Snake piece) {
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

    public Snake getPiece() {
        return piece;
    }
}
