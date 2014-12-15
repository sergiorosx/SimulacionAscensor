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
    private final int capacidadTotal;
    private final int tiempoArranque;
    private final int tiempoDesplazamiento;
    private boolean generaLlegada;
    // variables de suma de tiempo ascensor al otro piso
    private int tiempoSalidas;
    private int tiempoEntradas;
    private String paroAsc;
    // variables de desempeño
    private int atendidos;
    private double[] tPromEsperaxPiso = {0, 0, 0, 0, 0, 0}; // piso 1 al 6
    private double[] tPromEsperaColaEntradaSubexPiso = {0, 0, 0, 0, 0}; // piso 1 al 5
    private double[] tPromEsperaColaEntradaBajaxPiso = {0, 0, 0, 0, 0}; // piso 2 al 6
    //private double[] tPromEsperaColaSalidaxPiso = {0, 0, 0, 0, 0, 0}; // piso 1 al 6 -> este seria mejor para ver cuando tiempo dura el ascensor con cierto numero de personas
    
    
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
        // flag para indicar que hay que generar una llegada
        generaLlegada = false;
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
    
    public boolean getGeneraLlegada(){
        return generaLlegada;
    }
    
    public String getEstadoAscensor() {
        return estadoAscensor;
    }

    // se ejecuta el evento de llegada del ascensor a un piso de acuerdo al modelo del ascensor
    public void ejecutar(int reloj) {
        // 1. cambia direccion en los pisos extremos
        if (pisoAscensor == 6)
            dirAscensor = "Abajo";
        else if (pisoAscensor == 1)
            dirAscensor = "Arriba";
        // 2. verificar si el ascensor debe detenerse o no
        // si el el ascensor no esta vacio y las colas de entrada no estan vacias, entonces...
        if (capacidadOcupada != 0 && !colasEntradaVacias()){
            // ascensor se pone en marcha o sigue en marcha
            estadoAscensor = "En marcha";
            // 3. se verifica si hay alguien que se baje en el piso del ascensor
            if (!noBajanPersonasPisoAsc()) {
                // se activa flag para generar llegada
                generaLlegada = true;
                // se procede a desocupar la cola de bajada en el piso del ascensor
                bajanPersonas();
                // 4. si alguien no se sube al ascensor y va en la misma direccion
                if (!noSubenPersonasPisoAsc())
                    subirPersonas(reloj);
                paroAsc = "ParaEnPiso"; // ir al piso siguiente
            }// si alguien no se baja en el piso del ascensor
            else {
                // 4. alguien se sube al ascensor y va en la misma direccion
                if (!noSubenPersonasPisoAsc()) {
                    // se activa flag para generar llegada
                    generaLlegada = true; 
                    // ingresan las personas de la respectiva cola al ascensor
                    subirPersonas(reloj);
                    paroAsc = "ParaEnPiso";// ir al siguiente piso
                }
                else // el ascensor no para en piso
                    paroAsc = "NoParaEnPiso";// ir al piso siguiente
            }
        } else { // el ascensor queda parado
            estadoAscensor = "Parado";
            dirAscensor = "";
        }
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

    private boolean colasEntradaVacias() {
        return  colaEntradaSubeP1.isEmpty() &&
                colaEntradaSubeP2.isEmpty() &&
                colaEntradaBajaP2.isEmpty() &&
                colaEntradaSubeP3.isEmpty() &&
                colaEntradaBajaP3.isEmpty() &&
                colaEntradaSubeP4.isEmpty() &&
                colaEntradaBajaP4.isEmpty() &&
                colaEntradaSubeP5.isEmpty() &&
                colaEntradaBajaP5.isEmpty() &&
                colaEntradaBajaP6.isEmpty();
    }
    
    // devuelve true si la cola esta vacia, en otras palabras si nadie se baja
    private boolean noBajanPersonasPisoAsc() {
        switch (pisoAscensor) {
            case 1:
                return colaSalidaP1.isEmpty();
            case 2:
                return colaSalidaP2.isEmpty();
            case 3:
                return colaSalidaP3.isEmpty();
            case 4:
                return colaSalidaP4.isEmpty();
            case 5: 
                return colaSalidaP5.isEmpty();
            case 6: 
                return colaSalidaP6.isEmpty();
            default:
                return false;
        }
    }

    // se desocupa la cola de salida dependiendo del piso donde este el ascensor
    private void bajanPersonas() {
        switch (pisoAscensor) {
            case 1:
                do {
                    colaSalidaP1.remove(0);
                    capacidadOcupada--;
                    tiempoSalidas++; // debe quedar = 0 cada que finalize ejecutar()
                    atendidos++;
                } while (colaSalidaP1.isEmpty());
                break;
            case 2:
                do {
                    colaSalidaP2.remove(0);
                    capacidadOcupada--;
                    tiempoSalidas++;
                    atendidos++;
                } while (colaSalidaP2.isEmpty());
                break;                
            case 3:
                do {
                    colaSalidaP3.remove(0);
                    capacidadOcupada--;
                    tiempoSalidas++;
                    atendidos++;
                } while (colaSalidaP3.isEmpty());
                break;
            case 4:
                do {
                    colaSalidaP4.remove(0);
                    capacidadOcupada--;
                    tiempoSalidas++;
                    atendidos++;
                } while (colaSalidaP4.isEmpty());
                break;
            case 5: 
                do {
                    colaSalidaP5.remove(0);
                    capacidadOcupada--;
                    tiempoSalidas++;
                    atendidos++;
                } while (colaSalidaP5.isEmpty());
                break;
            case 6: 
                do {
                    colaSalidaP6.remove(0);
                    capacidadOcupada--;
                    atendidos++;
                } while (colaSalidaP6.isEmpty());
                break;
        }
    }

    // devuelve true si nadie se sube al ascensor en la misma direccion
    private boolean noSubenPersonasPisoAsc() {
        if ("Arriba".equals(dirAscensor)) {
            switch (pisoAscensor) {
                case 1:
                    return colaEntradaSubeP1.isEmpty();
                case 2:
                    return colaEntradaSubeP2.isEmpty();
                case 3:
                    return colaEntradaSubeP3.isEmpty();
                case 4:
                    return colaEntradaSubeP4.isEmpty();
                case 5:
                    return colaEntradaSubeP1.isEmpty();
                default:
                    return false;
            }
        }
        else {
            switch (pisoAscensor) {
                case 2:
                    return colaEntradaBajaP2.isEmpty();
                case 3:
                    return colaEntradaBajaP3.isEmpty();
                case 4:
                    return colaEntradaBajaP4.isEmpty();
                case 5:
                    return colaEntradaBajaP5.isEmpty();
                case 6:
                    return colaEntradaBajaP6.isEmpty();
                default:
                    return false;
            }
        }
    }

    private boolean ascensorLleno() {
        return capacidadOcupada == capacidadTotal;
    }

    private void subirPersonas(int reloj) {
        // 5. Ascensor lleno - vacio
        if (ascensorLleno()) {
            // ir al siguiente piso
        }
        else {
            if (capacidadOcupada == 0){
                dirAscensor = getDireccionDestino();
            }
        }
        
        //6. de acuerdo a la direccion del ascensor ingresan personas en las colas de entrada
        if ("Arriba".equals(dirAscensor)) { // el ascensor sube
            switch (pisoAscensor) {
                case 1:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaSubeP1.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 1, "Arriba");
                        colaSalidaP1.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaSubeP1.isEmpty());
                    break;
                case 2:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaSubeP2.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 2, "Arriba");
                        colaSalidaP2.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaSubeP2.isEmpty());
                    break;
                case 3:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaSubeP3.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 3, "Arriba");
                        colaSalidaP3.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaSubeP3.isEmpty());
                    break;
                case 4:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaSubeP4.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 4, "Arriba");
                        colaSalidaP4.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaSubeP4.isEmpty());
                    break;
                case 5:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaSubeP5.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 5, "Arriba");
                        colaSalidaP5.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaSubeP5.isEmpty());
                    break;
            }
        }
        else { // el ascensor baja
            switch (pisoAscensor) {
                case 2:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaBajaP2.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 2, "Abajo");
                        colaSalidaP2.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaBajaP2.isEmpty());
                    break;
                case 3:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaBajaP3.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 3, "Abajo");
                        colaSalidaP3.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaBajaP3.isEmpty());
                    break;
                case 4:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaBajaP4.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 4, "Abajo");
                        colaSalidaP4.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaBajaP4.isEmpty());
                    break;
                case 5:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaBajaP5.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 5, "Abajo");
                        colaSalidaP5.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaBajaP5.isEmpty());
                    break;
                case 6:
                    do {
                        if(ascensorLleno())
                            break;
                        capacidadOcupada++;
                        Persona evtPersona = colaEntradaBajaP6.remove(0);
                        calcularTiempoEspera(reloj - evtPersona.getHoraLlegada(), 6, "Abajo");
                        colaSalidaP6.add(evtPersona);
                        tiempoEntradas++;
                    } while(colaEntradaBajaP6.isEmpty());
                    break;
            }
        }
    }
    
    private String getDireccionDestino() {
        // se crean personas provisional
        Persona p1;
        Persona p2;
        
        // se elije la direccion de la persona que halla llegado primero a la cola de entrada
        switch (pisoAscensor) {
            case 1:
                Persona p = colaEntradaSubeP1.get(0);
                return p.getDirDestino();
            case 2: // cuando hay personas en las dos colas 
                p1 = colaEntradaSubeP2.get(0);
                p2 = colaEntradaBajaP2.get(0);
                if (p1.equals(null)) // si no hay nadie en la cola de subida
                    return p2.getDirDestino();
                else if (p2.equals(null)) // si no hay nadie en la cola de bajada
                    return p1.getDirDestino();
                else {// si hay dos personas en cada cola se escoge la que halla llegado antes
                    if (p1.getHoraLlegada() < p2.getHoraLlegada())
                        return p1.getDirDestino();
                    else
                        return p2.getDirDestino();
                }
            case 3:
                p1 = colaEntradaSubeP3.get(0);
                p2 = colaEntradaBajaP3.get(0);
                if (p1.equals(null))
                    return p2.getDirDestino();
                else if (p2.equals(null))
                    return p1.getDirDestino();
                else {
                    if (p1.getHoraLlegada() > p2.getHoraLlegada())
                        return p1.getDirDestino();
                    else
                        return p2.getDirDestino();
                }
            case 4:
                p1 = colaEntradaSubeP4.get(0);
                p2 = colaEntradaBajaP4.get(0);
                if (p1.equals(null))
                    return p2.getDirDestino();
                else if (p2.equals(null))
                    return p1.getDirDestino();
                else {
                    if (p1.getHoraLlegada() > p2.getHoraLlegada())
                        return p1.getDirDestino();
                    else
                        return p2.getDirDestino();
                }
            case 5:
                p1 = colaEntradaSubeP5.get(0);
                p2 = colaEntradaBajaP5.get(0);
                if (p1.equals(null))
                    return p2.getDirDestino();
                else if (p2.equals(null))
                    return p1.getDirDestino();
                else {
                    if (p1.getHoraLlegada() > p2.getHoraLlegada())
                        return p1.getDirDestino();
                    else
                        return p2.getDirDestino();
                }
            case 6:
                p = colaEntradaBajaP3.get(0);
                return p.getDirDestino();
            default:
                return "";
            }
    }

    private void calcularTiempoEspera(int tProm, int pisoAsc, String dirAsc) {
        if("Arriba".equals(dirAsc)) {
            // tiempo promedio de espera para piso n
            if (tPromEsperaxPiso[pisoAsc - 1] == 0)
                tPromEsperaxPiso[pisoAsc - 1] = tProm;
            else
                tPromEsperaxPiso[pisoAsc - 1] = (tPromEsperaxPiso[pisoAsc - 1] + tProm) /2;
            // tiempo promedio de espera para piso 1 para subir
            if (tPromEsperaColaEntradaSubexPiso[pisoAsc - 1] == 0)
                tPromEsperaColaEntradaSubexPiso[pisoAsc - 1] = tProm;
            else
                tPromEsperaColaEntradaSubexPiso[pisoAsc - 1] = (tPromEsperaColaEntradaSubexPiso[pisoAsc - 1] + tProm) / 2;
        }
        else {
            // tiempo promedio de espera para piso n
            if (tPromEsperaxPiso[pisoAsc - 1] == 0)
                tPromEsperaxPiso[pisoAsc - 1] = tProm;
            else
                tPromEsperaxPiso[pisoAsc - 1] = (tPromEsperaxPiso[pisoAsc - 1] + tProm) /2;
            // tiempo promedio de espera para piso 1 para subir
            if (tPromEsperaColaEntradaBajaxPiso[pisoAsc - 1] == 0)
                tPromEsperaColaEntradaBajaxPiso[pisoAsc - 1] = tProm;
            else
                tPromEsperaColaEntradaBajaxPiso[pisoAsc - 1] = (tPromEsperaColaEntradaBajaxPiso[pisoAsc - 1] + tProm) / 2;
        }
    }

    public int irPisoSiguiente(int tLlegada) {
        int proxLlegada;
        
        // nuevo piso del ascensor dependiendo de la direccion
        if (dirAscensor.equals("Arriba"))
            pisoAscensor++;
        else
            pisoAscensor--;
        
        // tiempo de llegada del ascensro al proximo piso, cuando para y no para en un piso
        if ("ParaEnPiso".equals(paroAsc))
            proxLlegada = tLlegada + tiempoArranque + tiempoDesplazamiento + tiempoSalidas + tiempoEntradas;
        else
            proxLlegada = tLlegada + tiempoDesplazamiento;
        // se reinician valores temporales
        tiempoSalidas = 0;
        tiempoEntradas = 0;
        paroAsc = "";
        
        return proxLlegada;
    }
}
