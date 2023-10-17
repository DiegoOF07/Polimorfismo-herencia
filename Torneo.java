/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta clase es el controlador del programa, en el cual se llevan a cabo todos los 
 * calculos necesarios para mostrar la informacion que el usuario necesite
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Torneo {
    private ArrayList<Jugador> jugadores;
    private Data data;

    public Torneo(){
        jugadores = new ArrayList<Jugador>();
        data = new Data("infoJugadores.csv");
    }

    
    /** 
     * @throws Exception
     */
    public void inicialize() throws Exception{
        data.createFile();
    }

    
    /** 
     * @return ArrayList<Jugador>
     * @throws Exception
     */
    public ArrayList<Jugador> mostrarJugadores() throws Exception{
        jugadores.clear();
        return data.readData();
    }

    
    /** 
     * @return Jugador[]
     * @throws Exception
     */
    public Jugador[] tresMejoresLiberos() throws Exception{
        downloadData();
        int cont = 0;
        Collections.sort(jugadores, new Comparator<Jugador>() {
            @Override
            public int compare(Jugador j1, Jugador j2) {
                return Double.valueOf(j1.efectividad()).compareTo(Double.valueOf(j2.efectividad()));
            }
        });
        Jugador[] tresMejoresLiberos=new Libero[3];
        for (Jugador jugador: jugadores) {
            if(cont<3){
               if(jugador instanceof Libero){
                   if(tresMejoresLiberos[cont]!=jugador) {
                       tresMejoresLiberos[cont] = jugador;
                       cont++;
                   }
               }
            }
        }
        jugadores.clear();
       return tresMejoresLiberos;
    }

    
    /** 
     * @return ArrayList<Jugador>
     * @throws Exception
     */
    public ArrayList<Jugador> pasadoresEfectivos() throws Exception {
        downloadData();
        ArrayList<Jugador> pasadoresEfectivos = new ArrayList<Jugador>();
        for (Jugador jugador: jugadores) {
            if(jugador instanceof Pasador){
                if(((Pasador)jugador).efectividad()>80){
                    pasadoresEfectivos.add(jugador);
                }
            }
        }
        jugadores.clear();
        return pasadoresEfectivos;
    }

    
    /** 
     * @param tipoJugador
     * @param nombre
     * @param pais
     * @param errores
     * @param aces
     * @param totalServicios
     * @param recibosEfectivos
     * @param pases
     * @param fintas
     * @param ataques
     * @param bloqueosEfec
     * @param bloqueosFall
     * @return boolean
     */
    public boolean agregarJugador(String tipoJugador, String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos, int pases, int fintas, int ataques, int bloqueosEfec, int bloqueosFall){
        if(!tipoJugador.isEmpty() && !nombre.isEmpty() && !pais.isEmpty() && errores>0 && aces > 0 && totalServicios > 0 && recibosEfectivos >= 0 && pases >= 0 && fintas >=0 && ataques >=0 && bloqueosEfec >=0 && bloqueosFall>=0){
            switch (tipoJugador){
                case "1":
                    jugadores.add(new Libero(nombre, pais,errores, aces, totalServicios, recibosEfectivos));
                    return true;
                case "2":
                    jugadores.add(new Pasador(nombre, pais, errores, aces, totalServicios, pases, fintas));
                    return true;
                case "3":
                    jugadores.add(new Auxiliar(nombre, pais, errores, aces, totalServicios,ataques, bloqueosEfec, bloqueosFall));
                    return true;
                default:
                    return false;
            }
        }else{
            return false;
        }
    }

    
    /** 
     * @throws Exception
     */
    public void uploadData() throws Exception{
        if(jugadores.size()>0){
            data.writeData(jugadores);
        }
    }

    
    /** 
     * @throws Exception
     */
    public void downloadData() throws Exception{
        for (Jugador jugador: data.readData()){
            jugadores.add(jugador);
        }
    }


}
