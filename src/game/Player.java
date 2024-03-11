package game;

public class Player {
    private String playerSymbol;
    private User id;
    private int timestampInMillis;

    public Player(String playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    public String symbol() {
        return this.playerSymbol;
    }

    public Player flip() {
        return new Player(this.symbol().equals("X") ? "O" : "X");
    }

    public void setTimeTaken(int timestampInMillis) {
        this.timestampInMillis += timestampInMillis;
    }

    public int getTimeUsedInMillis() {
        return this.timestampInMillis;
    }
}
