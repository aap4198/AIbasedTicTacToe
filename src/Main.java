
import java.util.Scanner;

import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import boards.Board;
import game.Cell;
import game.Move;
import game.Player;

public class Main {
    public static void main(String args[]) {
        try {
            GameEngine gameEngine = new GameEngine();
            Board board = gameEngine.start("TicTacToe");
            Scanner scanner = new Scanner(System.in);
            RuleEngine ruleEngine = new RuleEngine();
            AIEngine aiEngine = new AIEngine();
            while (!ruleEngine.getState(board).isOver()) {
                Player computer = new Player("O"), human = new Player("X");
                System.out.println("Make your move");
                System.out.println(board);
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                Move oppMove = new Move(new Cell(row, col), human);
                board = gameEngine.move(board, oppMove);
                if (!ruleEngine.getState(board).isOver()) {
                    Move computerMove = aiEngine.suggestMove(computer, board);
                    board = gameEngine.move(board, computerMove);
                }
            }
            System.out.println("Game Result" + ruleEngine.getState(board) + "And Winner is "
                    + ruleEngine.getState(board).getWinner());
            System.out.println(board);
        } catch (Exception e) {
            System.out.println("Error" + e);
        }
    }
}
