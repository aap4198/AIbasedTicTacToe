package placements;

import java.util.Optional;

import Utils.Utils;
import boards.TicTacToeBoard;
import game.Cell;
import game.Player;

public class CenterPlacement implements Placement {

    private static CenterPlacement centerPlacement;

    private CenterPlacement() {
    };

    public static synchronized CenterPlacement get() {
        centerPlacement = (CenterPlacement) Utils.getIfNull(centerPlacement, () -> new CenterPlacement());
        return centerPlacement;
    }

    public Optional<Cell> place(TicTacToeBoard board, Player player) {
        Cell centerCell = null;
        if (board.getSymbol(1, 1) == null) {
            centerCell = new Cell(1, 1);
        }
        return Optional.ofNullable(centerCell);
    };

    public Placement next() {
        return CornerPlacement.get();
    };
}
