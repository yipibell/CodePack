package Checkers.gamepices;

public enum PieceType {
    Blue(1), White(-1), BlueChecker(2), WhiteChecker(-2);

    public final int moveDir;

    PieceType(int moveDir) {
        this.moveDir = moveDir;
    }


}
