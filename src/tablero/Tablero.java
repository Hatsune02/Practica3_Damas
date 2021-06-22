package src.tablero;

public class Tablero{
    private Casilla[][] tablero;
    private boolean juegoEnBlancas = true;
    public int fichasBlancasComidas = 0;
    public int fichasNegrasComidas = 0;

    public Tablero(boolean jugarConBlancas  ){

        this.tablero = new Casilla[8][8];
        llenarTablero();
        llenarFichas(0, 3, jugarConBlancas);
        llenarFichas(5, 8, !jugarConBlancas);
    }

    public void dibujarTablero(String jugador1, String jugador2){
        System.out.println("\n");
        System.out.println("\tJugador1:" + jugador1 + "\t\t" + "Jugador2:" + jugador2);
        System.out.println("\n");
        int n = 1;
        for (int i = 0; i < tablero.length; i++) {
            for (int k = 0; k < 3; k++) {
                System.out.print("\n\t");
                for (int j = 0; j < tablero.length; j++) {
                    System.out.print(tablero[i][j].pintarCasilla(k));
                }
                if(k == 1){
                    System.out.print("\t" + n);
                    n++;
                }
            }
        }
        System.out.println("\n\t  1     2     3     4     5     6     7     8");
        System.out.println("\n\n");
    }

    private void llenarTablero(){

        boolean esColorInicio = false;
        boolean esColorIteracion = false;
        for ( int i = 0; i < tablero.length; i++) {
            esColorIteracion = !esColorInicio;
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = new Casilla(esColorIteracion);
                esColorIteracion = !esColorIteracion;
                
            }
            esColorInicio = !esColorInicio;
        }
    }

    public void llenarFichas(int inicio, int cantidad, boolean esBlanca){
        for (int i = inicio; i < cantidad; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i][j].getEsCasillaBlanca() == !juegoEnBlancas){
                    tablero[i][j].setFicha(new Ficha(!esBlanca));
                }
            }
        }
    }

    public void moverFicha(int x1, int y1, int x2, int y2, boolean turnoNegras){

        if(turnoNegras){
            if(tablero[x1][y1].ocupadaPorFicha()){

                if(!tablero[x1][y1].getFicha1().getEsNegra()){

                    if(1 - (x2 + y2) % 2 == 0){

                        if(!tablero[x1][y1].getFicha1().getEsReina()){

                            if(y1 == 0){
                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 + 1][y1 + 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == tablero.length-1){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }

                                    }
                                    else if(tablero[x2][y2] == tablero[x1 + 2][y1 + 2]){
                                        if(tablero[x1 + 1][y1 + 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 + 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 1){
                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 + 1][y1 + 1] || tablero[x2][y2] == tablero[x1 + 1][y1 - 1]){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == tablero.length-1){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }
                                    }
                                    else if(tablero[x2][y2] == tablero[x1 + 2][y1 + 2]){
                                        if(tablero[x1 + 1][y1 + 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 + 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 >= 2 || y1 <= 5){
                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 + 1][y1 + 1] || tablero[x2][y2] == tablero[x1 + 1][y1 - 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == tablero.length-1){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }

                                    }
                                    else if(tablero[x2][y2] == tablero[x1 + 2][y1 + 2] || tablero[x2][y2] == tablero[x1 + 2][y1 - 2]){
                                        if(tablero[x1 + 1][y1 + 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 + 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else if(tablero[x1 + 1][y1 - 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 - 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }

                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 7){

                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 + 1][y1 - 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == tablero.length-1){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }

                                    }
                                    else if(tablero[x2][y2] == tablero[x1 + 2][y1 - 2]){
                                        if(tablero[x1 + 1][y1 - 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 - 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 6){

                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 + 1][y1 + 1] || tablero[x2][y2] == tablero[x1 + 1][y1 - 1]){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == tablero.length-1){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }
                                    }
                                    else if(tablero[x2][y2] == tablero[x1 + 2][y1 - 2]){
                                        if(tablero[x1 + 1][y1 - 1].ocupadaPorFicha()){
                                            if(tablero[x1 + 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == tablero.length-1){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 + 1][y1 - 1].eliminarFicha();
                                                fichasBlancasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else{
                                System.out.println("No puedes mover mas de una posicion tu ficha");
                            }
                        }

                        else{
                            if(!tablero[x2][y2].ocupadaPorFicha()){
                                if(x2 > x1 && y2 > y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2-(i+1)][y2-(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2-(i+1)][y2-(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2-(i+1)][y2-(i+1)].eliminarFicha();
                                                    fichasBlancasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if(x2 > x1 && y2 < y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2-(i+1)][y2+(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2-(i+1)][y2+(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2-(i+1)][y2+(i+1)].eliminarFicha();
                                                    fichasBlancasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if(x2 < x1 && y2 > y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2+(i+1)][y2-(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2+(i+1)][y2-(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2+(i+1)][y2-(i+1)].eliminarFicha();
                                                    fichasBlancasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if (x2 < x1 && y2 < y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2+(i+1)][y2+(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2+(i+1)][y2+(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2+(i+1)][y2+(i+1)].eliminarFicha();
                                                    fichasBlancasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                            }
                            else{
                                System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                            }
                        }
                    }

                    else {
                        System.out.println("No se puede mover ahi la ficha");
                    }
                }
                else{
                    System.out.println("No puedes mover una ficha que no te pertenece");
                }
            }
            else{
                System.out.println("No existe la ficha que quieres mover");
            }
        }
        else{
            if(tablero[x1][y1].ocupadaPorFicha()){
                if(tablero[x1][y1].getFicha1().getEsNegra()){
                    if(1 - (x2 + y2) % 2 == 0){

                        if(!tablero[x1][y1].getFicha1().getEsReina()){
                            if(y1 == 0){
                                if (!tablero[x2][y2].ocupadaPorFicha()){

                                    if(tablero[x2][y2] == tablero[x1 - 1][y1 + 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == 0){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }
                                    }
                                    else if(tablero[x2][y2] == tablero[x1 - 2][y1 + 2]){
                                        if(tablero[x1 + 1][y1 + 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][y1 + 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 1){
                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 - 1][y1 + 1] || tablero[x2][y2] == tablero[x1 - 1][y1 - 1]){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == 0){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }
                                    }
                                    else if(tablero[x2][y2] == tablero[x1 - 2][y1 + 2]){
                                        if(tablero[x1 - 1][y1 + 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][y1 + 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 >= 2 && y1<= 5){
                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 - 1][y1 + 1] || tablero[x2][y2] == tablero[x1 - 1][y1 - 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == 0){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }

                                    }
                                    else if(tablero[x2][y2] == tablero[x1 - 2][y1 + 2] || tablero[x2][y2] == tablero[x1 - 2][y1 - 2]){
                                        if(tablero[x1 - 1][y1 + 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 + 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][y1 + 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else if(tablero[x1 - 1][y1 - 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][x1 - 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }

                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 7){

                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 - 1][y1 - 1]){

                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == 0){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }

                                    }
                                    else if(tablero[x2][y2] == tablero[x1 - 2][y1 - 2]){
                                        if(tablero[x1 - 1][y1 - 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][y1 - 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else if(y1 == 6){

                                if (!tablero[x2][y2].ocupadaPorFicha()){
                                    if(tablero[x2][y2] == tablero[x1 - 1][y1 + 1] || tablero[x2][y2] == tablero[x1 - 1][y1 - 1]){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                        if(x2 == 0){
                                            tablero[x2][y2].getFicha1().setEsReina(true);
                                        }
                                    }
                                    else if(tablero[x2][y2] == tablero[x1 - 2][y1 - 2]){
                                        if(tablero[x1 - 1][y1 - 1].ocupadaPorFicha()){
                                            if(!tablero[x1 - 1][y1 - 1].getFicha1().getEsNegra()){
                                                tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                                if(x2 == 0){
                                                    tablero[x2][y2].getFicha1().setEsReina(true);
                                                }
                                                tablero[x1 - 1][y1 - 1].eliminarFicha();
                                                fichasNegrasComidas++;
                                            }
                                            else{
                                                System.out.println("No puedes saltar tu ficha");
                                            }
                                        }
                                        else{
                                            System.out.println("No puedes hacer ese movimiento");
                                        }
                                    }
                                    else{
                                        System.out.println("No puedes mover mas de una posicion tu ficha");
                                    }
                                }
                                else{
                                    System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                                }
                            }

                            else{
                                System.out.println("No puedes mover mas de una posicion tu ficha");
                            }
                        }

                        else{
                            if(!tablero[x2][y2].ocupadaPorFicha()){
                                if(x2 > x1 && y2 > y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2-(i+1)][y2-(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2-(i+1)][y2-(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2-(i+1)][y2-(i+1)].eliminarFicha();
                                                    fichasNegrasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if(x2 > x1 && y2 < y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2-(i+1)][y2+(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2-(i+1)][y2+(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2-(i+1)][y2+(i+1)].eliminarFicha();
                                                    fichasNegrasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if(x2 < x1 && y2 > y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2+(i+1)][y2-(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2+(i+1)][y2-(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2+(i+1)][y2-(i+1)].eliminarFicha();
                                                    fichasNegrasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                                else if (x2 < x1 && y2 < y1){
                                    if(Math.abs(x2 - x1) == 1){
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                    else if(Math.abs(x2 - x1) > 1){
                                        for (int i = 0; i < (Math.abs(x2 - x1) - 1); i++) {
                                            if(tablero[x2+(i+1)][y2+(i+1)].ocupadaPorFicha()){
                                                if(tablero[x2+(i+1)][y2+(i+1)].getFicha1().getEsNegra()){
                                                    tablero[x2+(i+1)][y2+(i+1)].eliminarFicha();
                                                    fichasNegrasComidas++;
                                                }
                                            }
                                        }
                                        tablero[x2][y2].setFicha(tablero[x1][y1].getFicha());
                                    }
                                }
                            }
                            else{
                                System.out.println("Hay una ficha en la posicion que deseas mover tu ficha");
                            }
                        }
                    }
                }
                else{
                    System.out.println("No puedes mover una ficha que no te pertenece");
                }
            }
            else{
                System.out.println("No existe la ficha que quieres mover");
            }
        }
    }

}