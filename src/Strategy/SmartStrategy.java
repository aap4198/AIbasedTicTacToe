package Strategy;

import api.RuleEngine;
import boards.TicTacToeBoard;
import game.Cell;
import game.Move;
import game.Player;

public class SmartStrategy extends Strategy {
    RuleEngine ruleEngine = new RuleEngine();

    public Cell getOptimalMove(TicTacToeBoard board, Player player) {
        Cell best = offense(player, board);
        if (best != null)
            return best;
        // Defensive moves
        best = defense(player, board);
        if (best != null)
            return best;
        return new BasicStrategy().getOptimalMove(board, player);
    }

    private Cell offense(Player player, TicTacToeBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player);
                    TicTacToeBoard boardCopy = (TicTacToeBoard) board.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return move.getCell();
                    }
                }
            }
        }
        return null;
    }

    private Cell defense(Player player, TicTacToeBoard board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getSymbol(i, j) == null) {
                    Move move = new Move(new Cell(i, j), player.flip());
                    TicTacToeBoard boardCopy = (TicTacToeBoard) board.move(move);
                    if (ruleEngine.getState(boardCopy).isOver()) {
                        return new Cell(i, j);
                    }
                }
            }
        }
        return null;
    }
}
