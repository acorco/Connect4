/*
 * Juego conecta 4 simple en Java.
 * @author Alejandro Córcoles
 * @author alejandro@corco.technology
 */

import game.Grid;
import game.Player;
import utils.Color;
import utils.Logger;

import java.util.Scanner;

public class Main {
    private static Grid grid;
    public static void main(String[] args) {
       displayMenu();
    }

    private static void promptColumn(Player player){

        int col = Logger.getInt(player.getName() + ": Columna >> ");


        try{
            grid.insert(col, player);
        }catch (Exception e){
            Logger.println(Color.RED_BOLD, e.getMessage());
            promptColumn(player);
        }
    }

    private static void displayMenu(){
        System.out.println(Color.GREEN_BOLD);
        System.out.println("CONECTA 4 GAME");
        System.out.println("================");
        System.out.println("1. Jugar");
        System.out.println("2. Ranking");
        System.out.println("3. Exit");
        System.out.println(Color.RESET);
        int opc = Logger.getInt("\nOpció >> ");
        switch (opc){
            case 1:
                int n = Logger.getInt("Enter N value >> ");
                int m = Logger.getInt("Enter M value >> ");
                grid = new Grid(n,m);
                grid.draw();

                Player player1 = new Player("Alejandro", Color.RED_BOLD);
                Player player2 = new Player("Ken", Color.BLUE_BOLD);

                while (true){
                    promptColumn(player1);
                    grid.draw();
                    promptColumn(player2);
                    grid.draw();
                }
            case 2:
                break;
            case 3:
                break;
            default:
                Logger.println(Color.RED_BOLD, "Aquesta opció no existeix.");
                displayMenu();
        }
    }
}

