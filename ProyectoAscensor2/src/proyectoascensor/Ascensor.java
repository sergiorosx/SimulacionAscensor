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
    private String estadoAscensor;
    private String dirAscensor;
    private int pisoAscensor;
    private int pisoDestino;
    private int capacidadTotal;
    private int tiempoArranque;
    private int tiempoDesplazamiento;
    
    // colas de salida del ascensor
    private ArrayList colaSalidaP1;
    private ArrayList colaSalidaP2;
    private ArrayList colaSalidaP3;
    private ArrayList colaSalidaP4;
    private ArrayList colaSalidaP5;
    private ArrayList colaSalidaP6;
    
    /*
        metodo constructor para inicializar el ascensor en un piso cualquiera
    */
    public Ascensor (int pisoA, int capacidadT, int tiempoArr, int tiempoDespl) {
        capacidadOcupada = 0; // numero de personas dentro del ascensor
        estadoAscensor = "Parado";
        pisoAscensor = pisoA;
        capacidadTotal = capacidadT;
        tiempoArranque = tiempoArr;
        tiempoDesplazamiento = tiempoDespl;
    }
    
    public int getPisoAsc() {
        return pisoAscensor;
    }
    /* este metodo no se que hace, parece estar malo
    public int getTiempoLlegada (int cantidadAscensos, int cantidadDescensos) {
        
        int tiempoRecorrido;
                
        if (pisoAscensor < pisoDestino) {
            dirAscensor = "Arriba";            
        }else{
            dirAscensor = "Abajo";
        }
        
        tiempoRecorrido = tiempoDesplazamiento * Math.abs(pisoAscensor-pisoDestino) + tiempoArranque + cantidadAscensos + cantidadDescensos;
        
        return tiempoRecorrido;
    }*/ 

    public void ejecutar() {
        
    }
}
