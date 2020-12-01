package game.winner;

import game.Cell;
import game.Player;
import java.util.ArrayList;
import java.util.List;

public class DiagonalRule extends AbstractWinnerRule implements IWinnerRule{

    public Player check(Cell[][] grid, Player[] players, int i, int j) {
        for (Player player : players) {
            List<Cell> diagonalCells = new ArrayList<>();

            for (int k = 1; k <= 4; k++) {
                boolean rowIncrement = k <= 2;
                boolean columnIncrement = k % 2 != 0;

                for (int l = 1; l <= 4; l++) {
                    int newI = rowIncrement ? i + l : i - l;
                    int newJ = columnIncrement ? j + l : j - l;

                    try {
                        Cell diagonalCell = grid[newI][newJ];

                        if (diagonalCell.getPlayer() == player) {
                            diagonalCells.add(diagonalCell);

                            if (diagonalCells.size() == 3) {
                                diagonalCells.add(grid[i][j]);

                                this.setWinnerCells(diagonalCells);

                                return player;
                            }
                        } else {
                            diagonalCells.clear();
                            break;
                        }
                    } catch (Exception ignored) { }
                }
                diagonalCells.clear();
            }
        }

        return null;
    }
}
