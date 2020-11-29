package game.winner;

import game.Cell;

import java.util.List;

public abstract class AbstractWinnerRule {
    protected void setWinnerCells(List<Cell> cells) {
        for (Cell cell : cells) {
            cell.setWon();
        }
    }
}
