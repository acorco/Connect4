package utils;

public enum Color {
    // Resetear color
    RESET("\033[0m"),

    // Colores en negrita
    BLACK_BOLD("\033[1;30m"),   // Negro
    RED_BOLD("\033[1;31m"),     // Rojo
    GREEN_BOLD("\033[1;32m"),   // Verde
    YELLOW_BOLD("\033[1;33m"),  // Amarillo
    BLUE_BOLD("\033[1;34m"),    // Azul
    MAGENTA_BOLD("\033[1;35m"), // Magenta
    CYAN_BOLD("\033[1;36m"),    // Azul
    WHITE_BOLD("\033[1;37m");   // Blanco



    private final String code;


     // Constructor del enum
    Color(String code) {
        this.code = code;
    }

    @Override // El override se usa para sustituir la función toString.
    public String toString() {
        return code;
    }
}

