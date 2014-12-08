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
    
    
    public void generarPiso () {
        
        int[] pisosDestino = {1, 1, 1, 1, 2, 3, 4, 5, 6};
        int pisoDest;

        do {
            pisoDest = pisosDestino[(int) Math.floor(Math.random() * 9)];
        } while (pisoDest == pisoInicial);
        
        setPisoDestino(pisoDest);
        setDirDestino();
    }
    
    private void setDirDestino() {
        if (pisoInicial > pisoDestino) {
            dirDestino = "abajo";
        }
        else {
            dirDestino = "arriba";
        }
    }

    private void setPisoDestino(int pisoDest) {
        pisoDestino = pisoDest;
    }
    
}
