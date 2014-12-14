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
    
    // colas de entrada al ascensor piso 1
    private ArrayList<Persona> colaEntradaSubeP1;
    private ArrayList<Persona> colaEntradaSubeP2;
    private ArrayList<Persona> colaEntradaBajaP2;
    private ArrayList<Persona> colaEntradaSubeP3;
    private ArrayList<Persona> colaEntradaBajaP3;
    private ArrayList<Persona> colaEntradaSubeP4;
    private ArrayList<Persona> colaEntradaBajaP4;
    private ArrayList<Persona> colaEntradaSubeP5;
    private ArrayList<Persona> colaEntradaBajaP5;
    private ArrayList<Persona> colaEntradaBajaP6;
    
    // colas de salida del ascensor
    private ArrayList<Persona> colaSalidaP1;
    private ArrayList<Persona> colaSalidaP2;
    private ArrayList<Persona> colaSalidaP3;
    private ArrayList<Persona> colaSalidaP4;
    private ArrayList<Persona> colaSalidaP5;
    private ArrayList<Persona> colaSalidaP6;
    
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
        // se inicializan las colas de todos los pisos de entrada y salida
        colaEntradaSubeP1 = new ArrayList();
        colaEntradaSubeP2 = new ArrayList();
        colaEntradaBajaP2 = new ArrayList();
        colaEntradaSubeP3 = new ArrayList();
        colaEntradaBajaP3 = new ArrayList();
        colaEntradaSubeP4 = new ArrayList();
        colaEntradaBajaP4 = new ArrayList();
        colaEntradaSubeP5 = new ArrayList();
        colaEntradaBajaP5 = new ArrayList();
        colaEntradaBajaP6 = new ArrayList();
        colaSalidaP1 = new ArrayList();
        colaSalidaP2 = new ArrayList();
        colaSalidaP3 = new ArrayList();
        colaSalidaP4 = new ArrayList();
        colaSalidaP5 = new ArrayList();
        colaSalidaP6 = new ArrayList();
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

    public void addColaEntrada(Persona evtPersona) {
        // colas con direccion ascendente
        if(evtPersona.getDirDestino().equals("arriba")) {
            // colas para subir a un piso
            switch(evtPersona.getPisoInicial()) {
                case 1:
                    colaEntradaSubeP1.add(evtPersona);
                    break;
                case 2:
                    colaEntradaSubeP2.add(evtPersona);
                    break;
                case 3:
                    colaEntradaSubeP3.add(evtPersona);
                    break;
                case 4:
                    colaEntradaSubeP4.add(evtPersona);
                    break;
                case 5:
                    colaEntradaSubeP5.add(evtPersona);
                    break;
            }
        }
        else { // colas con direccion descente
            // colas para bajar a un piso
            switch(evtPersona.getPisoInicial()) {
                case 2:
                    colaEntradaBajaP2.add(evtPersona);
                    break;
                case 3:
                    colaEntradaBajaP3.add(evtPersona);
                    break;
                case 4:
                    colaEntradaBajaP4.add(evtPersona);
                    break;
                case 5:
                    colaEntradaBajaP5.add(evtPersona);
                    break;
                case 6:
                    colaEntradaBajaP6.add(evtPersona);
                    break;
            }
        }
    }
}
