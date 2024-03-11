package placements;

import java.util.Optional;

import Utils.Utils;
import boards.Board;
import boards.TicTacToeBoard;
import game.Cell;
import game.Player;

public class CornerPlacement implements Placement {

    private static CornerPlacement cornerPlacement;

    private CornerPlacement() {
    };

    public static synchronized CornerPlacement get() {
        cornerPlacement = (CornerPlacement) Utils.getIfNull(cornerPlacement, () -> new CornerPlacement());
        return cornerPlacement;
    }

    public Optional<Cell> place(TicTacToeBoard board, Player player) {
        Cell cornerCell = null;
        int[][] corners = new int[][] { { 0, 0 }, { 0, 2 }, { 2, 0 }, { 0, 2 } };
        for (int i = 0; i < corners.length; ++i) {
            if (board.getSymbol(corners[i][0], corners[i][1]) == null) {
                cornerCell = new Cell(corners[i][0], corners[i][1]);
            }
        }
        return Optional.ofNullable(cornerCell);
    };

    public Placement next() {
        return null;
    };
}
