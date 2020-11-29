package game.winner;

import game.Cell;
import game.Player;

import java.util.ArrayList;
import java.util.List;

public class HorizontalRule extends AbstractWinnerRule implements IWinnerRule {
    public Player check(Cell[][] grid, Player[] players, int i, int j) {
        for (Player player : players) {
            List<Cell> rowCells = new ArrayList<>();

            for (Cell[] cells : grid) {
                for (Cell cell : cells) {
                    if (cell.getPlayer() == player) {
                        rowCells.add(cell);

                        if (rowCells.size() == 4) {
                            this.setWinnerCells(rowCells);

                            return player;
                        }
                    } else {
                        rowCells.clear();
                    }
                }

                rowCells.clear();
            }
        }

        return null;
    }
}
