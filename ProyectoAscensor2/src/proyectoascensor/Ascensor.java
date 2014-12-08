package proyectoascensor;

import java.util.ArrayList;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Ascensor {
    
    // variables de estado del ascensor
    private int capacidadOcupada;
    private String estadoAsc;
    private String dirAsc;
    private int pisoAsc;
    // colas de salida del ascensor
    private ArrayList colaSalidaP1;
    private ArrayList colaSalidaP2;
    private ArrayList colaSalidaP3;
    private ArrayList colaSalidaP4;
    private ArrayList colaSalidaP5;
    private ArrayList colaSalidaP6;
    
    public Ascensor (int pisoAs) {
        capacidadOcupada = 0; // numero de personas dentro del ascensor
        estadoAsc = "Parado";
        dirAsc = "Arriba";
        pisoAsc = pisoAs;
    }
    
    public int getPisoAsc() {
        return pisoAsc;
    }
    
    private void siguientePiso () {
        
    }
    
}
