package boards;

import game.Move;

public interface Board {
    Board move(Move move);

    public abstract Board copy();
}
