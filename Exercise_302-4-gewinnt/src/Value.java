
public enum Value {
    PLAYER1(1), PLAYER2(-1), EMPTY(0),DRAW(42);

    private final int num;

    Value(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }
}