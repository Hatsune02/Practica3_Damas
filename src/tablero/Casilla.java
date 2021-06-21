package src.tablero;

import src.colores.*;

public class Casilla {

    private boolean esCasillaBlanca = true;
    private Ficha ficha;

    public Casilla(boolean esCasillaNegra){
        this.esCasillaBlanca = esCasillaNegra;
        ficha = null;
    }

    public String pintarCasilla(int numeroLinea){
        String linea = "";
        if(esCasillaBlanca){
            linea = pintarCasilla(Colores.ANSI_WHITE_BACKGROUND, numeroLinea, Colores.ANSI_RESET);
        }
        else{
            linea = pintarCasilla(Colores.ANSI_BLACK_BACKGROUND, numeroLinea, Colores.ANSI_RESET);
        }
        return linea;
    }

    public String pintarCasilla(String color, int numeroLinea, String volverColor){
        String linea;
        if(ficha != null){
            if(numeroLinea == 1){
                linea = color + "  " + ficha.getFicha() + "   " + volverColor;
            }
            else{
                linea = color + "      " + volverColor;
            }
        }
        else{
            linea = color + "      " + volverColor;
        }

        return linea;
    }
    
    public boolean ocupadaPorFicha(){
        return (ficha!=null);
    }

    public void setFicha(Ficha f){
        this.ficha = f;
    }

    public void eliminarFicha(){
        this.ficha = null;
    }

    public boolean getEsCasillaBlanca(){
        return this.esCasillaBlanca;
    }

    public Ficha getFicha(){
        Ficha tmp = this.ficha;
        this.ficha = null;
        return tmp;
    }

    public Ficha getFicha1(){
        return ficha;
    }
}
