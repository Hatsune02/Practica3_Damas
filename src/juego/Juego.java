package src.juego;

import src.jugadores.Jugador;
import src.miniGame.MiniGame;
import src.tablero.Tablero;

public class Juego {

    private Tablero tablero;
    public Jugador[] jugadores = new Jugador[10];
    private MiniGame miniGame = new MiniGame();
    public int cantidadJugadores = 0;

    public Juego(){

    }

    public void menu(){
        System.out.println("────────────────────────────────────────────────────────────────────────────────────\n" +
                "─████████████───██████████████─██████──────────██████─██████████████─██████████████─\n" +
                "─██░░░░░░░░████─██░░░░░░░░░░██─██░░██████████████░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─\n" +
                "─██░░████░░░░██─██░░██████░░██─██░░░░░░░░░░░░░░░░░░██─██░░██████░░██─██░░██████████─\n" +
                "─██░░██──██░░██─██░░██──██░░██─██░░██████░░██████░░██─██░░██──██░░██─██░░██─────────\n" +
                "─██░░██──██░░██─██░░██████░░██─██░░██──██░░██──██░░██─██░░██████░░██─██░░██████████─\n" +
                "─██░░██──██░░██─██░░░░░░░░░░██─██░░██──██░░██──██░░██─██░░░░░░░░░░██─██░░░░░░░░░░██─\n" +
                "─██░░██──██░░██─██░░██████░░██─██░░██──██████──██░░██─██░░██████░░██─██████████░░██─\n" +
                "─██░░██──██░░██─██░░██──██░░██─██░░██──────────██░░██─██░░██──██░░██─────────██░░██─\n" +
                "─██░░████░░░░██─██░░██──██░░██─██░░██──────────██░░██─██░░██──██░░██─██████████░░██─\n" +
                "─██░░░░░░░░████─██░░██──██░░██─██░░██──────────██░░██─██░░██──██░░██─██░░░░░░░░░░██─\n" +
                "─████████████───██████──██████─██████──────────██████─██████──██████─██████████████─\n" +
                "────────────────────────────────────────────────────────────────────────────────────\n\n");

        int opcion;

        do{
            System.out.println("MENU___________________________");
            System.out.println("\n1) Jugar.");
            System.out.println("2) Ingresar jugadores.");
            System.out.println("3) Mostrar Jugadores");
            System.out.println("4) Salir\n");
            opcion = IngresoDatos.getInt("Escoger una opcion");
            if(opcion == 1){
                if(cantidadJugadores > 0){
                    jugar();
                }
                else{
                    System.out.println("NO TIENES NINGUN JUGADOR\n");
                }

            }
            else if(opcion == 2){
                ingresarJugadores();
            }
            else if(opcion == 3){

                ordenarJugadores();
                mostrarJugador();
            }

        } while(opcion != 4);

    }

    public void inicio(){

        
    }
    public void jugar(){
        boolean turnoNegras = false;
        int jugador1;
        int jugador2;
        mostrarJugador();
        boolean ganadorBlanco = false;
        boolean ganadorNegro = false;
        boolean ganador= false;

        do{
            jugador1 = IngresoDatos.getInt("\nEscoger al primer jugador") ;
            jugador2 = IngresoDatos.getInt("\nEscoger al segundo jugador") ;
        }while(jugador1 < 1 && jugador1 >=cantidadJugadores && jugador2 < 1 && jugador2 >=cantidadJugadores);

        jugador1 = jugador1 - 1;
        jugador2 = jugador2 - 1;

        miniGame.juego(jugadores[jugador1], jugadores[jugador2]);

        boolean leTocaJugador1 = miniGame.escogeJugador1;

        if(leTocaJugador1){
            System.out.println(jugadores[jugador1].getNombre() + " Te toca escoger");
        }
        else{
            System.out.println(jugadores[jugador2].getNombre() + " Te toca escoger");
        }

        int opcion = IngresoDatos.getInt("1) Jugar con Blancas\t\t2) Jugar con Negras");

        if(leTocaJugador1){
            if(opcion == 1){
                jugadores[jugador1].setJuegaConNegras(false);
                jugadores[jugador2].setJuegaConNegras(true);
            }
            else{
                jugadores[jugador1].setJuegaConNegras(true);
                jugadores[jugador2].setJuegaConNegras(false);
            }
        }
        else{
            if(opcion == 1){
                jugadores[jugador1].setJuegaConNegras(true);
                jugadores[jugador2].setJuegaConNegras(false);
            }
            else{
                jugadores[jugador1].setJuegaConNegras(false);
                jugadores[jugador2].setJuegaConNegras(true);
            }
        }

        String turnoNegrasEscrito;
        String turnoBlancasEscrito;

        if(jugadores[jugador1].juegaConNegras){
            turnoBlancasEscrito = "TURNO DE LAS BLANCAS " + jugadores[jugador2].getNombre();
        }
        else{
            turnoBlancasEscrito = "TURNO DE LAS BLANCAS " + jugadores[jugador1].getNombre();
        }
        if(jugadores[jugador2].juegaConNegras){
            turnoNegrasEscrito = "TURNO DE LAS NEGRAS " + jugadores[jugador2].getNombre();
        }
        else{
            turnoNegrasEscrito = "TURNO DE LAS NEGRAS " + jugadores[jugador1].getNombre();
        }

        tablero = new Tablero(true);
        tablero.dibujarTablero(jugadores[jugador1].getNombre(), jugadores[jugador2].getNombre());

        do{
            if(!turnoNegras){
                System.out.println(turnoBlancasEscrito + "\n");
            }
            else{
                System.out.println(turnoNegrasEscrito + "\n");
            }

            pedirMovimiento(turnoNegras);
            tablero.dibujarTablero(jugadores[jugador1].getNombre(), jugadores[jugador2].getNombre());
            
            if(tablero.fichasBlancasComidas == 12){
                ganadorNegro = true;
                ganador = true;
            }
            else if(tablero.fichasNegrasComidas == 12){
                ganadorBlanco = true;
                ganador = true;
            }
            turnoNegras = !turnoNegras;

        } while(!ganador);


        if(ganadorBlanco){
            if(!jugadores[jugador1].juegaConNegras){
                System.out.println("\nHA GANADO EL JUGADOR " + jugadores[jugador1].getNombre() + "\n\n");
                jugadores[jugador1].cantidadWins++;
                jugadores[jugador2].cantidadLoses++;
            }
            else {
                jugadores[jugador2].cantidadWins++;
                jugadores[jugador1].cantidadLoses++;
                System.out.println("\nHA GANADO EL JUGADOR " + jugadores[jugador2].getNombre() + "\n\n");
            }
        }
        else if(ganadorNegro){
            if(jugadores[jugador1].juegaConNegras){
                jugadores[jugador1].cantidadWins++;
                jugadores[jugador2].cantidadLoses++;
                System.out.println("\nHA GANADO EL JUGADOR " + jugadores[jugador1].getNombre() + "\n\n");
            }
            else {
                jugadores[jugador2].cantidadWins++;
                jugadores[jugador1].cantidadLoses++;
                System.out.println("\nHA GANADO EL JUGADOR " + jugadores[jugador2].getNombre() + "\n\n");
            }
        }

    }

    public void pedirMovimiento(boolean turnoNegras){

        int x1 = IngresoDatos.getIntRango("Ingresa la posicion en x de la ficha que quiere moverse",8);
        int y1 = IngresoDatos.getIntRango("Ingresa la posicion en y de la ficha que quiere moverse",8);
        int x2 = IngresoDatos.getIntRango("Ingresa la posicion en x hacia donde quiere mover la ficha",8);
        int y2 = IngresoDatos.getIntRango("Ingresa la posicion en y hacia donde quiere mover la ficha",8);

        tablero.moverFicha((y1 - 1),(x1 - 1),(y2-1) ,(x2 -1) ,turnoNegras);
        
    }

    public void ingresarJugadores(){
        if(cantidadJugadores < 10){
            System.out.println("Ingrese el nombre del nuevo jugador, solo se pueden ingresar 10 jugadores maximo");
            System.out.println("número actual de jugadores: " + cantidadJugadores);
            String nombreJugador = IngresoDatos.getString("Nombre :");
            jugadores[cantidadJugadores] = new Jugador(nombreJugador);
            cantidadJugadores++;
            System.out.println("\n Se ha ingresado un nuevo jugador");
        }
        else{
            System.out.println("Alcanzaste el número maximo de jugadores");
            System.out.println("número actual de jugadores: " + cantidadJugadores);
        }

    }

    public void mostrarJugador(){
        if(cantidadJugadores > 0){
            System.out.println("_________JUGADORES______________");
            System.out.println("\nNo. Nombre\t\tVictorias\tDerrotas");
            for (int i = 0; i < cantidadJugadores; i++) {
                System.out.println((i+1) + ")  " + jugadores[i].getNombre() + "\t\t\t" + jugadores[i].getCantidadWins() + "\t" + jugadores[i].cantidadLoses);
            }
            System.out.println("\n");
        }
        else{
            System.out.println("No tienes ningun jugador\n\n");
        }

    }

    public void ordenarJugadores(){
        if(cantidadJugadores > 0){
            for (int i = 0; i < cantidadJugadores - 1; i++) {
                for (int j = 0; j < cantidadJugadores - 1; j++) {
                    if(jugadores[j].getCantidadWins() < jugadores[j+1].getCantidadWins()){
                        Jugador aux = jugadores[j];
                        jugadores[j] = jugadores[j+1];
                        jugadores[j+1] = aux;
                    }
                }
            }
        }
    }
}
