package placements;

import java.util.Optional;

import Utils.Utils;
import boards.Board;
import boards.TicTacToeBoard;
import game.Cell;
import game.Move;
import game.Player;

public class DefensivePlacement implements Placement {

    private static DefensivePlacement defensivePlacement;

    private DefensivePlacement() {
    };

    public static synchronized DefensivePlacement get() {
        defensivePlacement = (DefensivePlacement) Utils.getIfNull(defensivePlacement, () -> new DefensivePlacement());
        return defensivePlacement;
    }

    public Optional<Cell> place(TicTacToeBoard board, Player player) {
        return Optional.ofNullable(defense(player, board));
    };

    public Placement next() {
        return ForkPlacement.get();
    };

    public Cell defense(Player player, TicTacToeBoard board) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 1; j < 3; ++j) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy = board.copy();
                    boardCopy.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return new Cell(i, j);
                    }
                }
            }
        }
        return null;
    }
}
