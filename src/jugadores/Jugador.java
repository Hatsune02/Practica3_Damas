package src.jugadores;

public class Jugador {
    private String ficha;
    private String nombre;
    private int[][] fichas;

    public Jugador(String nombre){
        this.nombre = nombre;
        llenarFichas();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int[][] getFichas() {
        return fichas;
    }

    public void setFichas(int[][] fichas) {
        this.fichas = fichas;
    }

    private void llenarFichas() {
        this.fichas = new int[4][4];
        for (int i = 0; i < this.fichas.length; i++) {
            for (int j = 0; j < fichas.length; j++) {
                fichas[i][j] = 0;
            }
        }
    }
}
