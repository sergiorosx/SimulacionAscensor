package proyectoascensor;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Persona {
    
    private final int pisoInicial;
    private int pisoDestino;
    private String dirDestino;
    private int horaLlegada;
    
    
    public Persona (int horaLl, int pisoIni) {
        pisoInicial = pisoIni;
        horaLlegada = horaLl;
    }
    
    public int getPisoInicial() {
        return pisoInicial;
    }
    
    public int getPisoDestino() {
        return pisoDestino;
    }
    
    public int getHoraLlegada() {
        return horaLlegada;
    }
    
    public String getDirDestino() {
        return dirDestino;
    }
    
    private void generarPiso() {
        int[] pisosDestino = {1, 2, 3, 1, 4, 5, 1, 6, 1};
        do {
            pisoDestino = pisosDestino[(int) Math.floor(Math.random() * 9)];
        } while (pisoDestino == pisoInicial);
    }
    
    private void setDirDestino() {
        if (pisoInicial > pisoDestino)
            dirDestino = "Abajo";
        else
            dirDestino = "Arriba";
    }

    public void ejecutar() {
        generarPiso();
        setDirDestino();
    }
    
}
