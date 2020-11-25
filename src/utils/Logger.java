package utils;


import java.util.Scanner;

public class Logger {
    public static void println(Color color, String text) { // Funció per canviar el color amb salt de línea.
        System.out.print(color);
        System.out.println(text);
        System.out.print(Color.RESET);
    }

    public static void print(Color color, String text) { // Funció per canviar el color sense salt de línea.
        System.out.print(color);
        System.out.print(text);
        System.out.print(Color.RESET);
    }

    /* Funció recursiva que primer comprova si el número introduït
     * és un número int. Si no ho és, llença un missatge d'error i es crida a si mateixa un altre cop.
     */
    public static int getInt(String prompt) {

        Scanner scanner = new Scanner(System.in);

        Logger.print(Color.YELLOW_BOLD, prompt);

        String nextLine = scanner.nextLine();

        try {
            return Integer.parseInt(nextLine);
        } catch (NumberFormatException ignored) {
            Logger.println(Color.RED_BOLD, "Error. Has d'introduir un número.");

            return getInt(prompt);
        }
    }
}
