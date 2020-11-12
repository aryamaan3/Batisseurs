package display;

// import org.fusesource.jansi.AnsiConsole;

/**
 * Classe qui permet l'ajout de couleur dans le terminal
 */

public class Couleur {
    // Si les couleurs ne s'affichent pas pour les utilisateurs windows : utiliser la library jansi
    //AnsiConsole.systemInstall(); // permet d'avoir des sorties textuelles colorées

    // Variables provenant de StackOverflow : How to print color in console using System.out.println?
    // https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

    // Couleurs de texte
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    // Couleurs de background
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // Syntaxe : System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
    // System.out.println(ANSI_GREEN_BACKGROUND + "background" + ANSI_RESET);
    // Coupler les deux :
    // System.out.println(ANSI_GREEN_BACKGROUND + ANSI_RED + "Green background and red text" + ANSI_RESET);
}
