package placements;

import java.util.Optional;

import Utils.Utils;
import boards.TicTacToeBoard;
import game.Cell;
import game.GameInfo;
import game.Player;

public class ForkPlacement implements Placement {

    private static ForkPlacement forkPlacement;

    private ForkPlacement() {
    };

    public static synchronized ForkPlacement get() {
        forkPlacement = (ForkPlacement) Utils.getIfNull(forkPlacement, () -> new ForkPlacement());
        return forkPlacement;
    }

    public Optional<Cell> place(TicTacToeBoard board, Player player) {
        Cell best = null;
        GameInfo gameInfo = ruleEngine.getInfo(board);
        if (gameInfo.hasFork()) {
            best = gameInfo.getForkCell();
        }
        return Optional.ofNullable(best);
    };

    public Placement next() {
        return CenterPlacement.get();
    };
}
