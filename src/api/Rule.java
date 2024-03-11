package api;

import java.util.function.Function;

import boards.CellBoard;
import game.GameState;

public class Rule {
    Function<CellBoard, GameState> condition;

    public Rule(Function<CellBoard, GameState> condition) {
        this.condition = condition;
    }
}
