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
    public String dirAsc;
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
    
    public int getTiempoLlegada (int cantidadAscensos, int cantidadDescensos) {
        
        int tiempoRecorrido;
                
        if (pisoAsc < pisoDestino) {
            dirAsc = "Arriba";            
        }else{
            dirAsc = "Abajo";
        }
        
        tiempoRecorrido = tiempoDesplazamiento*Math.abs(pisoAsc-pisoDestino) + tiempoArranque + cantidadAscensos + cantidadDescensos;
        
        return tiempoRecorrido;
    } 
}
