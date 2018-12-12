
public enum Value {
    PLAYER1("Spieler 1"), PLAYER2("Spieler 2"), EMPTY("Nix"), DRAW("Unentschieden");

    private String action;

    public String getAction() {
        return this.action;
    }

    private Value(String action) {
        this.action = action;
    }

    public void setAction(String action) {
        this.action = action;
    }

}
