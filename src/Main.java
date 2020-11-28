/*
 * Juego conecta 4 simple en Java.
 * @author Alejandro Córcoles
 * @author alejandro@corco.technology
 */

import game.Grid;
import game.Player;
import game.PlayerManager;
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

                int n = Logger.getInt("Enter N value >> ");
                int m = Logger.getInt("Enter M value >> ");
                _grid = new Grid(n, m);
                _grid.draw();

                Player player1 = _playerManager.createPlayer(name1);
                player1.setColor(Color.BLUE_BOLD);
                Player player2 = _playerManager.createPlayer(name2);
                player2.setColor(Color.RED_BOLD);

                while (true) {
                    _promptColumn(player1);
                    _grid.draw();
                    _promptColumn(player2);
                    _grid.draw();
                }
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
        for (Player player : _playerManager.getRanking().values()) {
            Logger.printf(Color.MAGENTA_BOLD, "%s : %d", player.getName(), player.getPoints());
        }
    }
}

