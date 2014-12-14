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
<<<<<<< HEAD:ProyectoAscensor2/src/proyectoascensor/ControladorLef.java
        int capacidadOcupadaProm = 0;*/
        
=======
        int capacidadOcupadaProm = 0;

>>>>>>> 0d1726fa37b101dcfc79a306b6025405ad635542:ProyectoAscensor2/src/proyectoascensor/Lef.java
        // tiempo de simulacion maximo
        int tiempoSimulacion = tiempoParada;
        
        // reloj del sistema
        int reloj = 0;
        
        /******* SIMULACION *******/
        
        // inicializar LEF
        // generacion inicial de personas en todos los pisos
        for (int pisoIni = 1; pisoIni <= 6; pisoIni++) {
            evtPersona = new Persona(pisoIni); // horaLlegada, pisoInicial
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
<<<<<<< HEAD:ProyectoAscensor2/src/proyectoascensor/ControladorLef.java
    /*
=======
    
    private static ArrayList<ArrayList> ordenarLefMergeSort(ArrayList<ArrayList> lef) {
        // Caso base. Un arreglo de cero o un elemento ya esta ordenado,
        // asi que lo regresamos.
        if (lef.size() <= 1) {
            return lef;
        }
        int puntoMedio = lef.size() / 2;
        // Creamos subarreglo izquierdo
        ArrayList<ArrayList> izquierdo = new ArrayList<ArrayList>();
        
        for (int i = 0; i < puntoMedio; i++) {
            izquierdo.add(lef.get(i));
        }
        // Creamos el subarreglo derecho
        ArrayList<ArrayList> derecho = new ArrayList<ArrayList>();
        
        for (int i = 0; i < lef.size() - puntoMedio; i++) {
            derecho.add(lef.get(puntoMedio + i));
        }
        // Ordenamos las dos mitades recursivamente
        ArrayList<ArrayList> izquierdoOrdenado = ordenarLefMergeSort(izquierdo);
        ArrayList<ArrayList> derechoOrdenado = ordenarLefMergeSort(derecho);
        //Mezclamos la solucion---
        // El indice i es para recorrer el subarreglo izquierdo
        int i = 0;
        // El indice j es para recorrer el subarreglo derecho
        int j = 0;
        // En 'resultado' guardamos el resultado de la mezcla de los dos
        // subarreglos
        ArrayList<ArrayList> resultado = new ArrayList<ArrayList>();
        /**
         * Terminamos de mezclar cuando i + j ya recorrieron todos los elementos
         * de los dos subarreglos
         */
        while (i + j < izquierdoOrdenado.size() + derechoOrdenado.size()) {
            // a) Si i ya llego al ultimo elemento del subarreglo izquierdo
            // copiamos el valor del siguiente elemento del subarreglo
            // derecho e incrementamos el indice j para, en el siguiente,
            // ciclo copiar el elemento de subarreglo derecho que sigue
            if (i == izquierdoOrdenado.size()) {
                //resultado
                resultado.add(i + j, derechoOrdenado.get(j));
                j++;
                continue;
            }
            // Lo mismo que a) pero para el subarreglo derecho
            if (j == derechoOrdenado.size()) {
                resultado.add(i + j, izquierdoOrdenado.get(i));
                // resultado[i + j] = izquierdoOrdenado[i];
                i++;
                continue;
            }
            double elementoIzquierdo = (int) izquierdoOrdenado.get(i).get(1);
            double elementoDerecho = (int) derechoOrdenado.get(j).get(1);
            // Comparamos cual de los elementos que siguen es menor y ese
            // lo copiamos en resultado
            if (elementoIzquierdo <= elementoDerecho) {
                resultado.add(i + j, izquierdoOrdenado.get(i));
                //resultado[i + j] = elementoIzquierdo;
                i++;
            } else {
                resultado.add(i + j, derechoOrdenado.get(j));
                j++;
            }
        }
        return resultado;
    }
    
>>>>>>> 0d1726fa37b101dcfc79a306b6025405ad635542:ProyectoAscensor2/src/proyectoascensor/Lef.java
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
    */
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
