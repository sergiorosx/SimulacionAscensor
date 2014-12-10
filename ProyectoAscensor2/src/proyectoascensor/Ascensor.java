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
    private int pisoDestino;
    private int capacidad;
    private int tiempoArranque;
    private int tiempoDesplazamiento;
    // colas de salida del ascensor
    private ArrayList colaSalidaP1;
    private ArrayList colaSalidaP2;
    private ArrayList colaSalidaP3;
    private ArrayList colaSalidaP4;
    private ArrayList colaSalidaP5;
    private ArrayList colaSalidaP6;
    
    public Ascensor (int pisoActualAsc, int pisoDestinoAsc, int capacidad, int tiempoArranque, int tiempoDesplazamiento) {
        capacidadOcupada = 0; // numero de personas dentro del ascensor
        estadoAsc = "Parado";
        dirAsc = "Arriba";
        pisoAsc = pisoActualAsc;
        pisoDestino = pisoDestinoAsc;
        this.capacidad = capacidad;
        this.tiempoArranque = tiempoArranque;
        this.tiempoDesplazamiento = tiempoDesplazamiento;
    }
    
    public int getPisoAsc() {
        return pisoAsc;
    }
    
    public int getTiempoLlegada () {
        
        int tiempoRecorrido;
        
        estadoAsc = "En Movimiento";
        
        if (pisoAsc < pisoDestino) {
            dirAsc = "Arriba";            
        }else{
            dirAsc = "Abajo";
        }
        
        tiempoRecorrido = tiempoDesplazamiento;
        
        return tiempoRecorrido;
    } 
}
