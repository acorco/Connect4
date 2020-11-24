import game.Player;
import game.Cell;
import game.Grid;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter N value >> ");
        int n = 4;

        System.out.println("Enter M value >> ");
        int m = 4;

        Grid grid = new Grid(n,m);
        grid.draw();
    }
}

