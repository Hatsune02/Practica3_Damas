package src.juego;

import src.jugadores.Jugador;
import src.tablero.Tablero;

public class Juego {

    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;

    public Juego(Jugador jugador1, Jugador jugador2, Tablero tablero){
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.tablero = tablero;
    }

    public void colocarSimboloEnTablero(int[] posicion, Jugador jugador){
        if(this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1].equalsIgnoreCase(Tablero.SIMBOLO_VACIO)) {
            
            this.tablero.getTablero()[posicion[0] - 1][posicion[1] - 1] = "O"; //jugador.getSimbolo();//Se llena el tablero
            jugador.getFichas()[posicion[0] - 1][posicion[1] - 1] = 1;//Se llena la posicion del jugador
        } 
        
        else{
            System.out.println("espacio ocuado");
            colocarSimboloEnTablero(pedirPosicionDeFicha(jugador), jugador);
        }

    }

    public int[] pedirPosicionDeFicha(Jugador jugador){
        int[] posicion = new int[2];
        boolean repetir = false;

        System.out.println("Turno de  " + jugador.getNombre());

        do {
            posicion[0] = IngresoDatos.getInt("Ingrese su posicion en x: ");
            if (posicion[0] < 1 || posicion[0] > 3) {
                System.out.println("Posicion incorecta, Intente de [1-3]");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);

        do {
            posicion[1] = IngresoDatos.getInt("Ingrese su posicion en y: ");
            if (posicion[1] < 1 || posicion[1] > 3) {
                System.out.println("Posicion incorecta, Intente de [1-3]:");
                repetir = true;
            } else {
                repetir = false;
            }
        } while (repetir);


        return posicion;
    }
    
    
}
