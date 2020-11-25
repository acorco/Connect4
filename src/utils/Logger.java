package utils;


import java.util.Scanner;

public class Logger {
    public static void println(Color color, String text) { // Función para cambiar el color con salto de línea.
        System.out.print(color);
        System.out.println(text);
        System.out.print(Color.RESET);
    }

    public static void print(Color color, String text) { // Función para cambiar el color sin salto de línea.
        System.out.print(color);
        System.out.print(text);
        System.out.print(Color.RESET);
    }

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
