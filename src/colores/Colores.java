package src.colores;

public class Colores {
    
    public static int cantidadColores = 7;

    public static final String ANSI_RESET = "\u001B[0m";
    //Colores de letra
    public static final String ANSI_WHITE = "\u001B[37m";
    //Colores de fondo
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";



    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    public static String COLOR1 = "ROJO";
    public static String COLOR2 = "AZUL";
    public static String COLOR3 = "AMARILLO";
    public static String COLOR4 = "BLANCO";
    public static String COLOR5 = "VERDE";
    public static String COLOR6 = "MORADO";
    public static String COLOR7 = "CYAN";


    public static String coloresDeFondo[]={
        ANSI_BLACK_BACKGROUND,
        ANSI_WHITE_BACKGROUND,
        ANSI_CYAN_BACKGROUND,
        ANSI_YELLOW_BACKGROUND,
        ANSI_GREEN_BACKGROUND,
        ANSI_RED_BACKGROUND,
        ANSI_BLUE_BACKGROUND,
        ANSI_PURPLE_BACKGROUND,
    };

    public static String coloresDeLetra[]={
            ANSI_RED,
            ANSI_BLUE,
            ANSI_YELLOW,
            ANSI_WHITE,
            ANSI_GREEN,
            ANSI_PURPLE,
            ANSI_CYAN,
    };

    public static String coloresString[]={
            COLOR1,
            COLOR2,
            COLOR3,
            COLOR4,
            COLOR5,
            COLOR6,
            COLOR7,
    };


}
