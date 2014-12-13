/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author pipe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Datos para countingSortMin
        int a[] = {1, 4, 2, 4, 3, 4, 5, 1};
        int b[] = {5, 5, 5, 5, 5, 5, 5, 5};
        int k = 5;

        //Datos para binTreeSearchMin
        int c[] = {6, 8, 1, 3, 5};
        int d[] = {3, 5, 6, 8, 1};
        int e[] = {5, 6, 8, 1, 3};
        int f[] = {1, 3, 5, 6, 8};
        ArrayList<Integer> array = new ArrayList<Integer>(1);
        array.add(20);
        array.add(18);
        array.add(16);
        array.add(11);
        array.add(9);
        array.add(7);
        array.add(5);
        array.add(23);
        array.add(4);

//        System.out.println("Inicia countingSortMin en a");
//        countingSortMin(a, k);
//        System.out.println("Finaliza countingSortMin en a\n");
//
//        System.out.println("countingSortMin en b");
//        countingSortMin(b, k);
//        System.out.println("Finaliza countingSortMin en b\n");
//
//        System.out.println("binTreeSearchMin en c");
//        binTreeSearchMin(c);
//        System.out.println("Finaliza binTreeSearchMin en c\n");
//
//        System.out.println("binTreeSearchMin en d");
//        binTreeSearchMin(d);
//        System.out.println("Finaliza binTreeSearchMin en d\n");
//
//        System.out.println("binTreeSearchMin en e");
//        binTreeSearchMin(e);
//        System.out.println("Finaliza binTreeSearchMin en e\n");
//
//        System.out.println("binTreeSearchMin en f");
//        binTreeSearchMin(f);
//        System.out.println("Finaliza binTreeSearchMin en f\n");
        System.out.println("additionFinder en c");
        additionFinder(array, 33);
        System.out.println("Finaliza additionFinder en c\n");

    }

    public static void countingSortMin(int a[], int k) {

        int c[] = new int[k + 1];
        int max = 0;

        //La complejidad del primer ciclo es k
        for (int i = 0; i < c.length; i++) {
            c[i] = 0;
        }

        //La complejidad del segundo ciclo es n
        for (int j = 0; j < a.length; j++) {
            c[a[j]] = c[a[j]] + 1;
        }

//        
//        for (int j = 0; j < c.length; j++) {
//            System.out.println(c[j]);
//        }
        //La complejidad del tercer ciclo es k, pues se hacen k comparaciones
        for (int h = 0; h < c.length - 1; h++) {
            if (c[h] > c[h + 1]) {
                max = h;
            } else {
                max = -1;
            }
        }

        //La complejidad total es O(k + n + k) = O(2k + n), pero como k = O(n), entonces la complejidad total es O(n) 
        System.out.println(max);

    }

    public static void arrayMin(int a[]) {
        int size = a.length;

        //Primera condición de parada, si existe un único elemento, ese se retorna
        if (size == 1) {

            System.out.println(a[0]);

        } //Segunda condición de parada, se busca el menor elemento en un arreglo de dos posiciones
        //Se retorna el menor de los 2
        else if (size == 2) {
            if (a[0] < a[1]) {
                System.out.println(a[0]);
            } else {
                System.out.println(a[1]);
            }
        } //Tercera condición de parada, si el último elemento es mayor al primero es porque 
        //la lista ya está ordenada, por lo tanto se retorna el primer elemento
        else if (a[a.length - 1] > a[0]) {
            System.out.println(a[0]);
        } else {
            //Arreglos para lado derecho e izquierdo del arreglo, que contendrán la mitad derecha 
            //e izquierda del arreglo inicial, respectivamente
            int[] subArrayRight;
            int[] subArrayLeft;

            //Se crean los arreglos derecho e izquierdo dependiendo del tamaño inicial del arreglo de entrada
            //En caso de ser impar el tamaño de este arreglo, el arreglo izquierdo es una posición mayor al derecho
            if (size % 2 == 0) {
                subArrayLeft = new int[size / 2];
                reArrangeLeft(a, subArrayLeft);
                subArrayRight = new int[size / 2];
                reArrangeRight(a, subArrayRight);
            } else {
                subArrayLeft = new int[((size - 1) / 2) + 1];
                reArrangeLeft(a, subArrayLeft);
                subArrayRight = new int[size - subArrayLeft.length];
                reArrangeRight(a, subArrayRight);
            }

//            System.out.println("LeftTree");
//            for (int j = 0; j < subArrayLeft.length; j++) {
//                System.out.println(subArrayLeft[j]);
//            }
//
//            System.out.println("RightTree");
//            for (int j = 0; j < subArrayRight.length; j++) {
//                System.out.println(subArrayRight[j]);
//            }
            //Se compara si la primera posición del arreglo izquierdo es mayor a su última posición, si es así, 
            //es porque el mínimo está en este arreglo y se hace la búsqueda recursivamente en este arreglo
            if (subArrayLeft[0] >= subArrayLeft[subArrayLeft.length - 1]) {
//                System.out.println("Ingreso if");
//                System.out.println("Posicion 0 " + subArrayLeft[0]);
//                System.out.println("Posicion n " + subArrayLeft[subArrayLeft.length - 1]);
                arrayMin(subArrayLeft);
            } //Sino, se hace la recursión sobre el arreglo derecho
            else {
//                System.out.println("Ingreso else");
//                System.out.println("Posicion 0 " + subArrayRight[0]);
//                System.out.println("Posicion n " + subArrayRight[subArrayRight.length - 1]);
                arrayMin(subArrayRight);
            }
        }
        
        //Por lo tanto, se puede decir que la complejidad del algoritmo la da el recorrido sobre los subarreglos derecho
        //e izquierdo, puesto que siempre se recorren 2^i (i = iteraciones) arreglos y como la complejidad de hallar estos es logn
        //entonces este algoritmo es O(n)

    }

    //Método para inicializar el arreglo izquierdo
    public static int[] reArrangeLeft(int[] init, int[] second) {

        //La complejidad de este for es logn, puesto que siempre recorre la mitad de los elementos del árbol en cada iteración
        //Puesto que cada vez se dividirá el arreglo en 2^i arreglos
        for (int i = 0; i < second.length; i++) {

            second[i] = init[i];
            //System.out.println(second[i]);

        }

        return second;
    }

    //Método para inicializar el arreglo derecho
    public static int[] reArrangeRight(int[] init, int[] second) {

        //La complejidad de este for es logn, puesto que siempre recorre la mitad de los elementos del árbol en cada iteración
        //Puesto que cada vez se dividirá el arreglo en 2^i arreglos
        for (int i = 0; i < second.length; i++) {

            second[i] = init[second.length + i + 1];
            //System.out.println(second[i]);

        }

        return second;
    }

    public static void additionFinder(ArrayList<Integer> array, int x) {

        //Organizamos el arreglo de entrada, con MergeSort, cuya complejidad es O(n)
        array = mergeSort(array);

        //Variable para recorrer el arreglo por la izquierda
        int i = 0;
        //Variable para recorrer el arreglo por la izquierda
        int j = array.size() - 1;

        //Imprimir arreglo ordenado
//        for (int y = 0; y <= j; y++) {
//            System.out.println("posicion " + (y+1) + " es: " + array.get(y));
//        }
        //Se recorre el arreglo, reduciendo los valores para recorrer el arreglo
        //En el peor caso, se recorrerán j-1 posiciones, esto es, cuando 
        //i = j-1, o j = i-1, pero como j = n, entonces tendremos:
        //i = n-1 o n = i-1
        while (i != j) {
//            System.out.println(i + " valor de i");
//            System.out.println(j + " valor de j");
            if (array.get(i) + array.get(j) == x) {
                System.out.println("El valor S[i], donde i = " + (i + 1) + " es: " + array.get(i)
                        + "\nEl valor S[j], donde j = " + (j + 1) + " es: " + array.get(j)
                        + "\nPara el x = " + x);
                break;
            } else if (array.get(j) >= x || (array.get(i) + array.get(j)) > x) {
                j--;
            } else if ((array.get(i) + array.get(j)) < x) {
                i++;
            }
        }
    }

    private static ArrayList<Integer> mergeSort(ArrayList<Integer> array) {
        // Caso base. Un arreglo de cero o un elemento ya esta ordenado,
        // asi que lo regresamos.
        if (array.size() <= 1) {
            return array;
        }
        int puntoMedio = array.size() / 2;
        // Creamos subarreglo izquierdo
        ArrayList<Integer> izquierdo = new ArrayList<Integer>();
        for (int i = 0; i < puntoMedio; i++) {
            izquierdo.add(array.get(i));
        }
        // Creamos el subarreglo derecho
        ArrayList<Integer> derecho = new ArrayList<Integer>();
        for (int i = 0; i < array.size() - puntoMedio; i++) {
            derecho.add(array.get(puntoMedio + i));
        }
        // Ordenamos las dos mitades recursivamente
        ArrayList<Integer> izquierdoOrdenado = mergeSort(izquierdo);
        ArrayList<Integer> derechoOrdenado = mergeSort(derecho);
        //Mezclamos la solucion---
        // El indice i es para recorrer el subarreglo izquierdo
        int i = 0;
        // El indice j es para recorrer el subarreglo derecho
        int j = 0;
        // En 'resultado' guardamos el resultado de la mezcla de los dos
        // subarreglos
        ArrayList<Integer> resultado = new ArrayList<Integer>();
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
            double elementoIzquierdo = izquierdoOrdenado.get(i);
            double elementoDerecho = derechoOrdenado.get(j);
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
}
