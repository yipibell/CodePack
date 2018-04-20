package Snake.gamepices;

public enum SnakeType {
    Snake(1), SnakeEatApple(2);

    public final int moveDir;

    SnakeType(int moveDir) {
        this.moveDir = moveDir;
    }


}
