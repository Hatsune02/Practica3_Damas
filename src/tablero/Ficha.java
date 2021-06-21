package src.tablero;

import src.colores.*;

public class Ficha {
    private String ficha = "◯";
    private final boolean esNegra;
    private boolean esReina = false;

    public Ficha(boolean esNegra){
        this.esNegra = esNegra;
        pintarFicha(ficha);
    }

    public void pintarFicha(String ficha){
        if(esNegra){
            this.ficha = Colores.ANSI_BLUE + ficha;
        }
        else{
            this.ficha = Colores.ANSI_RED + ficha;
        }
    }

    public String getFicha() {
        return ficha;
    }

    public boolean getEsNegra(){
        return esNegra;
    }

    public void setEsReina(boolean esReina) {
        this.esReina = esReina;
        ficha = "D";
    }

    public boolean getEsReina(){
        return esReina;
    }

}
