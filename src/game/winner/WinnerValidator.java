package game.winner;

import game.Cell;
import game.Player;

public class WinnerValidator {
    private final static IWinnerRule[] _winnerRules = new IWinnerRule[] {
            new HorizontalRule(),
            new VerticalRule(),
            new DiagonalRule()
    };

    public static Player checkWinners(Cell[][] grid, Player[] players, int i, int j) {

        for(IWinnerRule rule : _winnerRules) {
            Player winner = rule.check(grid, players, i, j);

            if (winner != null) {
                return winner;
            }
        }

        return null;
    }
}
