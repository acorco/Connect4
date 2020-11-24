import game.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = 0, cols = 0;

        do{
        System.out.print("Quantes files vols? (minim 4) >> ");
        rows = in.nextInt();

        System.out.print("Quantes columnes vols? (minim 4) >>  ");
        cols = in.nextInt();
        }while (rows < 4 && cols < 4);

        char[][] grid = new char[rows][cols];

        //initialize array
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }



        int turn = 1;
        boolean winner = false;

        System.out.print("Introdueix el nom del primer jugador >> ");
        Player player1 = new Player(in.next());
        System.out.print("Introdueix el nom del seogn jugador >> ");
        Player player2 = new Player(in.next());


        Player current = new Player(player1.getName());
        current.copy(player1);
        //play a turn
        while (!winner && turn <= 42) {

            boolean validPlay;
            int play;
            do {
                display(grid);

                System.out.print("Torn de " + current.getName() + ", escolleix: ");
                play = in.nextInt() - 1;

                //validate play
                validPlay = validate(play, grid);

            } while (!validPlay);

            //drop the checker
            for (int row = grid.length - 1; row >= 0; row--) {
                if (grid[row][play] == ' ') {
                    grid[row][play] = current.getSymbol();
                    break;
                }
            }

            //determine if there is a winner
            winner = isWinner(current.getSymbol(), grid);

            //switch players
            if (current.getName().equals(player1.getName())) {
                current.copy(player2);
            } else {
                current.copy(player1);
            }

            turn++;
        }
        display(grid);

        if (winner) {
            if (current.getName().equals(player1.getName())) {
                System.out.println("Ha guanyat " + player1.getName());
            } else {
                System.out.println("Ha guanyat " + player2.getName());
            }
        } else {
            System.out.println("Empat");
        }

    }

    public static void display(char[][] grid) {
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++) {
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++) {
                System.out.print(grid[row][col]);
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 1 2 3 4 5 6 7");
        System.out.println();
    }

    public static boolean validate(int column, char[][] grid) {
        //valid column?
        if (column < 0 || column > grid[0].length) {
            return false;
        }

        //full column?
        if (grid[0][column] != ' ') {
            return false;
        }

        return true;
    }

    public static boolean isWinner(char player, char[][] grid) {
        //check for 4 across
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row][col + 1] == player &&
                        grid[row][col + 2] == player &&
                        grid[row][col + 3] == player) {
                    return true;
                }
            }
        }
        //check for 4 up and down
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col] == player &&
                        grid[row + 2][col] == player &&
                        grid[row + 3][col] == player) {
                    return true;
                }
            }
        }
        //check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row - 1][col + 1] == player &&
                        grid[row - 2][col + 2] == player &&
                        grid[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        //check downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                        grid[row + 1][col + 1] == player &&
                        grid[row + 2][col + 2] == player &&
                        grid[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false;
    }
 }

