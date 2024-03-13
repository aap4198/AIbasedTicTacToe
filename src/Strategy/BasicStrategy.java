package Strategy;

import boards.TicTacToeBoard;
import game.Cell;
import game.Player;

public class BasicStrategy extends Strategy {
    public Cell getOptimalMove(TicTacToeBoard board, Player player) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    return new Cell(i, j);
                }
            }
        }
        return null;
    };
}
