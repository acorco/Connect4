/*
 * Juego conecta 4 simple en Java.
 * @author Alejandro Córcoles
 * @author alejandro@corco.technology
 */

import game.Grid;
import utils.Color;
import utils.Logger;

import java.util.Scanner;

public class Main {
    private static Grid grid;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger.println(Color.YELLOW_BOLD, "Enter N value >> ");
        int n = 4;

        Logger.println(Color.YELLOW_BOLD, "Enter M value >> ");
        int m = 4;



        System.out.print(Color.WHITE_BOLD); // Cambiamos el color de la letra en pantalla a blanco.
        grid = new Grid(n,m);
        grid.draw();
        System.out.print(Color.RESET);
        promptColumn();
    }

    private static void promptColumn(){

        int col = Logger.getInt("Columna >> ");


        try{
            grid.insert(col);
        }catch (Exception e){
            Logger.println(Color.RED_BOLD, e.getMessage());
            promptColumn();
        }
    }
}

