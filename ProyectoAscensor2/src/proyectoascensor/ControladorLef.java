package proyectoascensor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class ControladorLef {
    
    // variables del escenario, para el ascensor
    private int capacidadAsc;
    private int tiempoArranque;
    private int despEntrePisos;
    // lista de enventos futuros
    private ArrayList<Evento> LEF;
    /*private String estadoAscensor;
    private String dirAscensor;*/
    
    public void iniciarSimulacion (String escenario, int pisoAscensor, int tiempoParada) {
        /******  INICIALIZAR   ******/
        // configuracion del escenario
        setEscenario(escenario);
        // inicializacion del evento ascensor
        Ascensor evtAscensor = new Ascensor(pisoAscensor, capacidadAsc, tiempoArranque, despEntrePisos);
        // evento persona
        Persona evtPersona;
        
        // lista de eventos futuros
        LEF = new ArrayList<>();
        
        // variables de desempeño
        /*double[] tiempoPromEsperaxPiso = {0, 0, 0, 0, 0, 0};
        double tiempoPromEspera = 0.0;
        double[] tiempoPromEsperaColaEntradaSubidaxPiso = {0, 0, 0, 0, 0}; // piso 1 al 5
        double[] tiempoPromEsperaColaEntradaBajadaxPiso = {0, 0, 0, 0, 0}; // piso 2 al 6
        double tiempoPromEsperaColaEntradaTotal = 0;
        double[] tiempoPromEsperaColaSalidaxPiso = {0, 0, 0, 0, 0, 0}; // piso 1 al 6
        double tiempoPromEsperaColaSalidaTotal = 0;
        double porcPersonasAtendidas = 0;
        int capacidadOcupadaProm = 0;*/
        
        // tiempo de simulacion maximo
        int tiempoSimulacion = tiempoParada;
        
        // reloj del sistema
        int reloj = 0;
        
        /******* SIMULACION *******/
        
        // inicializar LEF
        // generacion inicial de personas en todos los pisos
        for (int pisoIni = 1; pisoIni <= 6; pisoIni++) {
            evtPersona = new Persona(pisoIni); // pisoInicial
            insertar(evtPersona, "P", 0); // info evento, tipo evento, horaLlegada
        }
        
        // agrega evento ascensor al LEF
        insertar(evtAscensor, "A", 0); // info evento, tipo evento, hora llegada
        
        // ejecutar simulacion
        do {
            // si el LEF queda vacio se aborta la simulacion (condicion provisional)
            if (!LEF.isEmpty()) {
                // se extrae el evento futuro del LEF
                Evento evento = LEF.remove(0);
                // evento llegada de persona
                if (evento.getTipoEvt().equals("P")) {
                    evtPersona = (Persona) evento.getEvtObject();
                    System.out.println("P " + evento.getHoraLl());
                    //evtPersona.ejecutar();
                    
                }
                // evento llegada de ascensor a un piso
                else {
                    evtAscensor = (Ascensor) evento.getEvtObject();
                    System.out.println("A " + evento.getHoraLl());
                    //evtAscensor.ejecutar();
                }
            }
            else {
                System.out.println("algo no anda bien");
                break;
            }
            reloj++;
        } while (reloj != tiempoSimulacion);
        
        System.out.println("end simulation");
        
        /******* RESULTADOS *******/
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
    
    // inserta en el left un objeto evento que contiene informacion del tipo 
    // de evento persona o ascensor, el tipo de evento P o A y la hora de ejecucion del evento
    public void insertar(Object o, String tipoEvt, int horaLl) {
        // se crea el evento con la informacion, tipo y hora de generacion
        Evento e = new Evento(o, tipoEvt, horaLl);
        // se agrega al LEF
        LEF.add(e);
        // se ordena el LEF teniendo en cuenta la horaLl
        Collections.sort(LEF, new Comparador());
    }
}
