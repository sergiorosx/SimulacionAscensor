package proyectoascensor;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Persona {
    
    private int pisoInicial;
    private int pisoDestino;
    private String dirDestino;
    private int horaLlegada;
    
    
    public int generarPiso () {
        
        int[] pisosDestino = {1, 1, 1, 1, 2, 3, 4, 5, 6};
        int pisoDest;

        do {
            pisoDest = pisosDestino[(int) Math.floor(Math.random() * 9)];
        } while (pisoDest == pisoInicial);
        
        setPisoDestino(pisoDest);
        setDirDestino();
        
        return pisoDest;
    }
    
    private void setDirDestino() {
        if (pisoInicial > pisoDestino) {
            dirDestino = "Abajo";
        }
        else {
            dirDestino = "Arriba";
        }
    }

    private void setPisoDestino(int pisoDest) {
        pisoDestino = pisoDest;
    }
    
}
