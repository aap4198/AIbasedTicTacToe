package Strategy;

import boards.TicTacToeBoard;
import game.Player;

public class StrategyFactory {

    private int countMoves(TicTacToeBoard board) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) != null) {
                    count++;
                }
            }
        }
        return count;
    }

    public Strategy getStrategy(TicTacToeBoard b, Player player) {
        Strategy strategy;
        int threshold = 3;
        if (countMoves(b) < threshold) {
            strategy = new BasicStrategy();
        } else if (countMoves(b) < threshold + 1) {
            strategy = new SmartStrategy();
        } else if (player.getTimeUsedInMillis() > 100000) {
            strategy = new BasicStrategy();
        } else {
            strategy = new OptimalStrategy();
        }
        return strategy;
    }
}
