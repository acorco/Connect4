package game.winner;

import game.Cell;
import game.Player;

import java.util.ArrayList;
import java.util.List;

public class VerticalRule extends AbstractWinnerRule implements IWinnerRule {

    public Player check(Cell[][] grid, Player[] players, int lastI, int lastJ) {
        for (Player player : players) {
            List<Cell> columnCells = new ArrayList<>();

            for (int j = 0; j < grid[0].length; j++) {
                for (int i = 0; i < grid.length; i++) {
                    Cell cell = grid[i][j];

                    if (cell.getPlayer() == player) {
                        columnCells.add(cell);

                        if (columnCells.size() == 4) {
                            this.setWinnerCells(columnCells);

                            return player;
                        }
                    } else {
                        columnCells.clear();
                    }
                }

                columnCells.clear();
            }
        }
        return null;
    }
}
