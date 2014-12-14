/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoascensor;

/**
 * @author Felipe Murillo
 * @author Esteban Llanos
 * @author Sergio Garcia 
 */
public class Evento {
    
    private Object evtObject;
    private String tipoEvt;
    private int horaLl;
    
    // evento que almacena un evento de tipo persona o ascensor y su hora de llegada
    public Evento(Object o, String tipo, int horall) {
        evtObject = o;
        tipoEvt = tipo;
        horaLl = horall;
    }
    
    public Object getEvtObject() {
        return evtObject;
    }
    
    // devuelve hora de llegada del evento
    public int getHoraLl() {
        return horaLl;
    }
    
    public String getTipoEvt () {
        return tipoEvt;
    }
    
    public void setHoraLl(int horall) {
        horaLl = horall;
    }
}
