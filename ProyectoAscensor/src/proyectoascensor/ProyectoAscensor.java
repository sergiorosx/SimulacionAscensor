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

    int pisoAsc = 1;
    
    public ArrayList crearLEF(){
        return null;
    }

    public int[] generarPersonas(){
        
        double a = 0;
        int[] arregloPersonas;
        int aleatorio = 0;
        int[] arregloPisos = {1, 1, 1, 1, 2, 3, 4, 5, 6};
        int numeroPersonas = 0;
        double lambdaPrimerPiso = 0.0025;
        double lambdaPisoUnoASeis = 0.002;
        // Math.random() retorna por defecto un valor entre 1 y 0 con una distribucion 
        // uniforme.
        double r = Math.random();
        
        if (pisoAsc==1) {
            a = (-1)*(1/lambdaPrimerPiso)*Math.log(r);
            numeroPersonas = (int) a*6 + 1;
            arregloPersonas = new int[numeroPersonas];
        }else{
            a = (-1)*(1/lambdaPisoUnoASeis)*Math.log(r);
            numeroPersonas = (int) a*6 + 1;
            arregloPersonas = new int[numeroPersonas];
        }
        
        for (int i = 0; i < arregloPersonas.length; i++) {
            aleatorio = (int) Math.floor(Math.random()*9);
            arregloPersonas[i] = arregloPisos[aleatorio];
        }
        
        return arregloPersonas;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        ProyectoAscensor p = new ProyectoAscensor();
        int[] arreglo = p.generarPersonas();
        
        for (int i = 0; i < arreglo.length; i++) {
            System.out.println("Posiscion " + i + ": " + arreglo[i]);
        }
    }
    
}
