package src.miniGame;

import src.jugadores.Jugador;

public class MiniGame {
    public boolean escogeJugador1;
    private String[] opciones = OpcionesJugador.opciones;
    
    public MiniGame(){

    }

    public void juego(Jugador jugador1, Jugador jugador2){
        String damas = "██████╗░██╗███████╗██████╗░██████╗░░█████╗░        ██████╗░░█████╗░██████╗░███████╗██╗░░░░░        \n" +
                "██╔══██╗██║██╔════╝██╔══██╗██╔══██╗██╔══██╗        ██╔══██╗██╔══██╗██╔══██╗██╔════╝██║░░░░░        \n" +
                "██████╔╝██║█████╗░░██║░░██║██████╔╝███████║        ██████╔╝███████║██████╔╝█████╗░░██║░░░░░        \n" +
                "██╔═══╝░██║██╔══╝░░██║░░██║██╔══██╗██╔══██║        ██╔═══╝░██╔══██║██╔═══╝░██╔══╝░░██║░░░░░        \n" +
                "██║░░░░░██║███████╗██████╔╝██║░░██║██║░░██║        ██║░░░░░██║░░██║██║░░░░░███████╗███████╗        \n" +
                "╚═╝░░░░░╚═╝╚══════╝╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝        ╚═╝░░░░░╚═╝░░╚═╝╚═╝░░░░░╚══════╝╚══════╝        \n" +
                "\n" +
                "░█████╗░        ████████╗██╗░░░░░██╗███████╗██████╗░░█████╗░\n" +
                "██╔══██╗        ╚══██╔══╝██║░░░░░██║██╔════╝██╔══██╗██╔══██╗\n" +
                "██║░░██║        ░░░██║░░░██║░░░░░██║█████╗░░██████╔╝███████║\n" +
                "██║░░██║        ░░░██║░░░██║██╗░░██║██╔══╝░░██╔══██╗██╔══██║\n" +
                "╚█████╔╝        ░░░██║░░░██║╚█████╔╝███████╗██║░░██║██║░░██║\n" +
                "░╚════╝░        ░░░╚═╝░░░╚═╝░╚════╝░╚══════╝╚═╝░░╚═╝╚═╝░░╚═╝\n\n";
        String ya = "\t\t░░███╗░░        ██████╗░        ██████╗░        ██╗░░░██╗░█████╗░██╗\n" +
                "\t\t░████║░░        ╚════██╗        ╚════██╗        ╚██╗░██╔╝██╔══██╗██║\n" +
                "\t\t██╔██║░░        ░░███╔═╝        ░█████╔╝        ░╚████╔╝░███████║██║\n" +
                "\t\t╚═╝██║░░        ██╔══╝░░        ░╚═══██╗        ░░╚██╔╝░░██╔══██║╚═╝\n" +
                "\t\t███████╗        ███████╗        ██████╔╝        ░░░██║░░░██║░░██║██╗\n" +
                "\t\t╚══════╝        ╚══════╝        ╚═════╝░        ░░░╚═╝░░░╚═╝░░╚═╝╚═╝";
        System.out.println(damas);
        System.out.println(ya);

        int opcionRival1 = generaNumeroR(0, 2);
        int opcionRival2 = generaNumeroR(0, 2);

        if(opcionRival1 == 0 && opcionRival2 == 0){
            System.out.println(opciones[0]);
            System.out.println("\n\n\t\t\t\tEMPATE REPITIENDO"+"\n\n");
            juego(jugador1,jugador2);
        }

        else if(opcionRival1 == 0 && opcionRival2 == 1){
            System.out.println(opciones[1]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador2.getNombre()+"\n\n");
            escogeJugador1 = false;
        }

        else if(opcionRival1 == 0 && opcionRival2 == 2){
            System.out.println(opciones[2]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador1.getNombre()+"\n\n");
            escogeJugador1 = true;
        }

        else if(opcionRival1 == 1 && opcionRival2 == 0){
            System.out.println(opciones[3]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador1.getNombre()+"\n\n");
            escogeJugador1 = true;
        }

        else if(opcionRival1 == 1 && opcionRival2 == 1){
            System.out.println(opciones[4]);
            System.out.println("\n\n\t\t\t\tEMPATE REPITIENDO"+"\n\n");
            juego(jugador1, jugador2);
        }

        else if(opcionRival1 == 1 && opcionRival2 == 2){
            System.out.println(opciones[5]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador2.getNombre()+"\n\n");
            escogeJugador1 = false;
        }

        else if(opcionRival1 == 2 && opcionRival2 == 0){
            System.out.println(opciones[6]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador2.getNombre()+"\n\n");
            escogeJugador1 = false;
        }

        else if(opcionRival1 == 2 && opcionRival2 == 1){
            System.out.println(opciones[7]);
            System.out.println("\n\n\t\t\t\tGANO " + jugador1.getNombre()+"\n\n");
            escogeJugador1 = true;
        }

        else if(opcionRival1 == 2 && opcionRival2 == 2){
            System.out.println(opciones[8]);
            System.out.println("\n\n\t\tEMPATE REPITIENDO"+"\n\n");
            juego(jugador1, jugador2);
        }

    }

    public int generaNumeroR(int minimo, int maximo) {

        int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + (minimo));
        return num;

    }
}
