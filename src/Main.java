/*
 * Juego conecta 4 simple en Java.
 * @author Alejandro Córcoles
 * @author alejandro@corco.technology
 */

import game.Grid;
import game.Player;
import game.PlayerManager;
import game.Tie;
import game.winner.WinnerValidator;
import utils.Color;
import utils.Logger;

public class Main {
    private static Grid _grid;
    private static PlayerManager _playerManager;

    public static void main(String[] args) {
        _playerManager = new PlayerManager();
        _displayMenu();
    }

    private static void _promptColumn(Player player) {

        int col = Logger.getInt(player.getName() + ": Columna >> ");


        try {
            _grid.insert(col, player);
        } catch (Exception e) {
            Logger.println(Color.RED_BOLD, e.getMessage());
            _promptColumn(player);
        }
    }

    private static void _displayMenu() {
        System.out.println(Color.GREEN_BOLD);
        System.out.println("CONECTA 4 GAME");
        System.out.println("================");
        System.out.println("1. Jugar");
        System.out.println("2. Ranking");
        System.out.println("3. Exit");
        System.out.println(Color.RESET);
        int opc = Logger.getInt("\nOpció >> ");
        switch (opc) {
            case 1:
                String name1 = Logger.getString("Introdueix el nom del primer jugador >> ");
                String name2 = Logger.getString("Introdueix el nom del segon jugador >> ");

                Player player1 = _playerManager.createPlayer(name1);
                player1.setColor(Color.BLUE_BOLD);
                Player player2 = _playerManager.createPlayer(name2);
                player2.setColor(Color.RED_BOLD);

                int w = Logger.getInt("Enter W value >> ", 4);
                int h = Logger.getInt("Enter H value >> ", 4);

                Player[] players = new Player[]{ player1, player2 };

                _grid = new Grid(w, h, players);
                _grid.draw();

                boolean winner = false;
                boolean tie = false;
                while (!winner && !tie) {
                    for (Player player : players) {
                        _promptColumn(player);
                        int i = _grid.lastI();
                        int j= _grid.lastJ();

                        Player winnerPlayer = WinnerValidator.checkWinners(_grid.getGrid(), players, i, j);

                        if (winnerPlayer == null) {
                            tie = Tie.validate(_grid.getGrid());
                            _grid.draw();
                            if (tie){
                                Logger.println(Color.YELLOW_BOLD, "No hi ha cap guanyador. Empat.");
                            }
                        } else {
                            _grid.setWinner(player);
                            _grid.draw();
                            Logger.printf(Color.MAGENTA_BOLD, "\nEl ganador es: %s\n", player.getName());

                            winner = true;
                            break;
                        }
                    }
                }

                _displayMenu();
            case 2:
                _displayRanking();
                _displayMenu();
                break;
            case 3:
                Runtime.getRuntime().exit(0);
                break;
            default:
                Logger.println(Color.RED_BOLD, "Aquesta opció no existeix.");
                _displayMenu();
        }
    }

    private static void _displayRanking() {
        for (Player player : _playerManager.getRanking()) {
            Logger.printf(Color.MAGENTA_BOLD, "%s : %d%n", player.getName(), player.getPoints());
        }
    }
}

