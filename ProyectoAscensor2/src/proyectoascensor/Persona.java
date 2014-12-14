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
    
    
    public Persona (int pisoIni) {
        pisoInicial = pisoIni;
    }
    
    public int getPisoInicial() {
        return pisoInicial;
    }
    
    public int generarPiso() {
        
        int[] pisosDestino = {1, 2, 3, 1, 4, 5, 1, 6, 1};

        do {
            pisoDestino = pisosDestino[(int) Math.floor(Math.random() * 9)];
        } while (pisoDestino == pisoInicial);
        
        setDirDestino();
        
        return pisoDestino;
    }
    
    private void setDirDestino() {
        if (pisoInicial > pisoDestino) {
            dirDestino = "Abajo";
        }
        else {
            dirDestino = "Arriba";
        }
    }

    public void ejecutar() {
        
    }
}
