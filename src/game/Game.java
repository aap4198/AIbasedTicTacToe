package game;

import boards.Board;

public class Game {
    private GameConfig gameConfig;
    private Board board;
    Player winner;
    private int lastMoveTimeInMillis;
    private int maxTimePerMove;
    private int maxTimePerPlayer;

    public Game(Move move, int timestampInMillis) {
        int timeTakenSinceLastMove = timestampInMillis - lastMoveTimeInMillis;
        move.getPlayer().setTimeTaken(timeTakenSinceLastMove);
        if (gameConfig.timed) {
            moveForTimedGame(move, timeTakenSinceLastMove);
        } else {
            board.move(move);
        }
    }

    private void moveForTimedGame(Move move, int timeTakenSinceLastMove) {
        int currentTime = gameConfig.timePerMove != null ? timeTakenSinceLastMove
                : move.getPlayer().getTimeUsedInMillis();
        int endTime = gameConfig.timePerMove != null ? maxTimePerMove : maxTimePerPlayer;
        if (moveMadeInTime(currentTime, endTime)) {
            board.move(move);
        } else {
            winner = move.getPlayer().flip();
        }
    }

    private boolean moveMadeInTime(int currentTime, int endTime) {
        return currentTime < endTime;
    }
}
