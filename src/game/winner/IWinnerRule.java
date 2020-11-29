package game.winner;

import game.Cell;
import game.Player;

public interface IWinnerRule {
    Player check(Cell[][] grid, Player[] players, int i, int j);
}
