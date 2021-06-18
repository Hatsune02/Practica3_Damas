package src.tablero;

import src.colores.Colores;

public class Tablero{
    private String[][] tablero;
    //public static final String SIMBOLO_VACIO = Colores.ANSI_RED + "O" + Colores.ANSI_RESET;
    public static final String SIMBOLO_VACIO = " ";
    
    public Tablero(){
        this.tablero = new String[8][8];
        llenarTablero();
    }

    public String[][] getTablero() {
        return tablero;
    }

    public void setTablero(String[][] tablero) {
        this.tablero = tablero;
    }

    public void dibujarTablero(String jugador1, String jugador2){
        System.out.println("\n");
        System.out.println("\tJugador1:" + jugador1 + "\t\t" + "Jugador2:" + jugador2);
        System.out.println("\n");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                
            }
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print(tablero[i][j] + "  " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print(tablero[i][j] + "  " + Colores.ANSI_RESET);
                }
                
            }
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                
            }
        }
        System.out.println("\n");
    }

    public void dibujarTablero() {
        System.out.println("\n\n");
        for (int i = 0; i < tablero.length; i++) {
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                
            }
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print(tablero[i][j] + "  " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print(tablero[i][j] + "  " + Colores.ANSI_RESET);
                }
                
            }
            System.out.print("\n\t");
            for (int j = 0; j < tablero.length; j++) {
                if((i + j) % 2 == 0){
                    System.out.print(Colores.ANSI_BLACK_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                else{
                    System.out.print(Colores.ANSI_WHITE_BACKGROUND + "  ");
                    System.out.print("   " + Colores.ANSI_RESET);
                }
                
            }
        }
        System.out.println("\n");
        
    }


    private void llenarTablero() {
        
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if(i == 0 || i == 1){
                    if((i + j) % 2 == 0){
                        tablero[i][j] = Colores.ANSI_BLUE + "O";
                    }
                    else{
                        tablero[i][j] = SIMBOLO_VACIO;
                    }
                }

                else if(i == 6 || i == 7){
                    
                    if((i + j) % 2 == 0){
                        tablero[i][j] = Colores.ANSI_RED + "O";
                    }
                    else{
                        tablero[i][j] = SIMBOLO_VACIO;
                    }
                }

                else{
                    tablero[i][j] = SIMBOLO_VACIO;
                }             
            }

        }
    }
}