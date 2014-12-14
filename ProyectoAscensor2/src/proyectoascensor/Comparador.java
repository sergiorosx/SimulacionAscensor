/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoascensor;

import java.util.Comparator;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Comparador implements Comparator<Evento>{
    // ordena los eventos con el atributo hora de llegada de menor a mayor
    @Override
    public int compare(Evento e, Evento e1) {
        if (e.getHoraLl() > e1.getHoraLl()) 
            return 1;
        else if (e.getHoraLl() == e1.getHoraLl())
            return 0;
        else 
            return -1;
    }
}
