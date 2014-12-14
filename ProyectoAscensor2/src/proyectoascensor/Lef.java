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

        // tiempo de simulacion maximo
        int tiempoSimulacion = tiempoParada;
        
        // reloj del sistema
        int reloj = 0;
        
        // inicializar LEF
        
        
        
        /******* SIMULACION *******/
        
        
        
        /******* RESULTADOS *******/
    }
    
    private ArrayList<ArrayList> ordenarLefMergeSort(ArrayList<ArrayList> lef) {
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
