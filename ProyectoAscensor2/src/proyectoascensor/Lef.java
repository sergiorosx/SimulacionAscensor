package proyectoascensor;

import java.util.ArrayList;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Lef {
    
    // variables del escenario
    private int capacidadAsc;
    private int tiempoArranque;
    private int despEntrePisos;
    private String estadoAscensor;
    private String dirAscensor;
    
    public void iniciarSimulacion (String escenario, int pisoAscensor, int tiempoParada) {
        /******  INICIALIZAR   ******/
        // configuracion del escenario
        setEscenario(escenario);
        estadoAscensor = "Parado";
        dirAscensor = "Arriba";
        
        ArrayList<ArrayList> LEF = new ArrayList<>();
        
        ArrayList personasIniciales = new ArrayList();
        int[] colaEsperaxPiso = {0, 0, 0, 0, 0, 0};
        
        for (int i = 0; i < 5; i++) {
            personasIniciales.add("LlegadaPersona");
            personasIniciales.add(0);
            LEF.add(personasIniciales);
            colaEsperaxPiso[i] = 1;
        }
        
        // variables de desempeño
        double[] tiempoPromEsperaxPiso = {0, 0, 0, 0, 0, 0};
        double tiempoPromEspera = 0.0;
        double[] tiempoPromEsperaColaEntradaSubidaxPiso = {0, 0, 0, 0, 0}; // piso 1 al 5
        double[] tiempoPromEsperaColaEntradaBajadaxPiso = {0, 0, 0, 0, 0}; // piso 2 al 6
        double tiempoPromEsperaColaEntradaTotal = 0;
        double[] tiempoPromEsperaColaSalidaxPiso = {0, 0, 0, 0, 0, 0}; // piso 1 al 6
        double tiempoPromEsperaColaSalidaTotal = 0;
        double porcPersonasAtendidas = 0;
        int capacidadOcupadaProm = 0;
        
        // Inicializar ascensor
        
        // tiempo de simulacion maximo
        int tiempoSimulacion = tiempoParada;
        
        // reloj del sistema
        int reloj = 0;
        
        // inicializar LEF
        
        
        
        /******* SIMULACION *******/
        
        
        
        /******* RESULTADOS *******/
    }
    
    public ArrayList crearEventoPersona(int pisoAsc){
        
        estadoAscensor = "En Movimiento";
        
        int tiempoLlegada = generarTiempoEntreLlegadas(pisoAsc);
        ArrayList eventoPersona = new ArrayList<>();
        Persona persona = new Persona();
        int pisoDestino = persona.generarPiso();
        
        eventoPersona.add("LlegadaPersona");
        eventoPersona.add(tiempoLlegada);
        
        return eventoPersona;
    }
    
    public ArrayList<ArrayList> crearEventoAscensor(int pisoActualAsc, int pisoDestinoAsc, int cantidadAscensos, int cantidadDescensos){
        
        estadoAscensor = "Parado";
        
        ArrayList eventoAscensor = new ArrayList<>();
        Ascensor ascensor = new Ascensor(pisoActualAsc, pisoDestinoAsc, capacidadAsc, tiempoArranque, despEntrePisos);
        
        eventoAscensor.add("LlegadaAscensor");
        eventoAscensor.add(ascensor.getTiempoLlegada(cantidadAscensos, cantidadDescensos));
        
        dirAscensor = ascensor.dirAsc;
        
        return eventoAscensor;
    }
    
    private void setEscenario(String escenario) {
        switch (escenario) {
            case "Escenario 1":
                capacidadAsc = 4;
                tiempoArranque = 20;
                despEntrePisos = 100;
                break;
            case "Escenario 2":
                capacidadAsc = 6;
                tiempoArranque = 20;
                despEntrePisos = 100;
                break;
            case "Escenario 3":
                capacidadAsc = 4;
                tiempoArranque = 5;
                despEntrePisos = 30;
                break;
            case "Escenario 4":
                capacidadAsc = 6;
                tiempoArranque = 5;
                despEntrePisos = 30;
                break;
        }
    }
    
    private int generarTiempoEntreLlegadas (int pisoAsc) {
        double a = 0;
        double lambda1 = 0.04; // para el piso 1
        double lambda2 = 0.02; // para los demas pisos
        // r = Math.random() retorna por defecto un valor entre 1 y 0 con una distribucion
        // uniforme.
        if (pisoAsc == 1) {
            a = -(1 / lambda1) * Math.log(Math.random());
            return (int) a;
        } else {
            a = -(1 / lambda2) * Math.log(Math.random());
            return (int) a;
        }
    }
}
