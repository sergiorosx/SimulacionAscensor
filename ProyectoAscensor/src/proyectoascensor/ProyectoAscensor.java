/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoascensor;

import java.util.ArrayList;

/**
 *
 * @author Luisfemm
 */
public class ProyectoAscensor {

    // inicio
    double reloj = 0.0;

    // variables de estado
    int capacidadOcupada = 0;
    String estadoAsc = "Parado";
    String dirAsc = "arriba";

    String dirDest = null;
    int pisoDest = 1;
    // variables de desempeño

    double[] tiempoPromEsperaxpiso = {0, 0, 0, 0, 0, 0};
    double tiempoPromEspera = 0.0;
    double[] tiempoPromEsperaColaEntradaSubidaxpiso = {0, 0, 0, 0, 0}; // piso 1 al 5
    double[] tiempoPromEsperaColaEntradaBajadaxpiso = {0, 0, 0, 0, 0}; // piso 2 al 6
    double tiempoPromEsperaColaEntradaTotal = 0;
    double[] tiempoPromEsperaColaSalidaxpiso = {0, 0, 0, 0, 0, 0}; // piso 1 al 6
    double tiempopromEsperaColaSalidaTotal = 0;
    double porcPersonasAtendidas = 0;
    int capacidadOcupadaProm = 0;

    // Definición del escenario 0
    int capacidadAsc = 4;
    int tiempoArranque = 20;
    int despEntrePisos = 100;
    int pisoAsc = 1;

    public ArrayList crearLEF() {
        return null;
    }

    public void inicializarAscensor(int capacidadAsc, int tiempoArranque, int tiempoDesplEntrePisos, int pisoAsc, int estadoAsc) {

    }
    
    public void mostrarResultados(){}
    
    public int generarTiempoLlegada() {

        double a = 0;
        int tiempoEntreLlegadas;
        int numeroPersonas = 0;
        double lambdaPrimerPiso = 0.04;
        double lambdaPisoUnoASeis = 0.02;
        // Math.random() retorna por defecto un valor entre 1 y 0 con una distribucion 
        // uniforme.
        double r = Math.random();

        if (pisoAsc == 1) {
            a = -(1 / lambdaPrimerPiso) * Math.log(r);
            tiempoEntreLlegadas = (int) a;
        } else {
            a = -(1 / lambdaPisoUnoASeis) * Math.log(r);
            tiempoEntreLlegadas = (int) a;
        }

        return tiempoEntreLlegadas;
    }

    public int generarPiso(int pisoActual) {

        int aleatorio = 0;
        int piso = 1;

        int[] arregloPisos = {1, 1, 1, 1, 2, 3, 4, 5, 6};
        aleatorio = (int) Math.floor(Math.random() * 9);
        piso = arregloPisos[aleatorio];

        while (piso == pisoActual) {
            aleatorio = (int) Math.floor(Math.random() * 9);
            piso = arregloPisos[aleatorio];
        }
        
        return piso;

    }
    
    public void ejecutarSimulacion(){
        int tiempo = generarTiempoLlegada();
        int piso = generarPiso(pisoAsc);

        System.out.println("Tiempo: " + tiempo);
        System.out.println("Piso: " + piso);
    }

    public static void main(String[] args) {
        // TODO code application logic here
        ProyectoAscensor p = new ProyectoAscensor();
        p.ejecutarSimulacion();
    }

}
