package src.jugadores;

public class Jugador {
    private String nombre;
    public int cantidadWins = 0;
    public int cantidadLoses = 0;
    public boolean juegaConNegras;

    public Jugador(String nombre){
        this.nombre = nombre;

    }

    public void setJuegaConNegras(boolean juegaConNegras) {
        this.juegaConNegras = juegaConNegras;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadWins() {
        return cantidadWins;
    }

}
