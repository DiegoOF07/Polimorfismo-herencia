/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta es una clase hija de la clase Jugador y se encarga de modelar a todos los Pasadores
 * 
 */

public class Pasador extends Jugador{

    private int pases;
    private int fintas;
    public Pasador(String nombre, String pais, int errores, int aces, int totalServicios, int pases, int fintas) {
        super(nombre, pais, errores, aces, totalServicios);
        this.pases = pases;
        this.fintas = fintas;
    }

    
    /** 
     * @return double
     */
    @Override
    public double efectividad() {
        return ((pases+fintas-errores)*100/(pases+fintas+errores))+super.efectividad();
    }

    
    /** 
     * @return int
     */
    public int getPases() {
        return pases;
    }

    
    /** 
     * @param pases
     */
    public void setPases(int pases) {
        this.pases = pases;
    }

    
    /** 
     * @return int
     */
    public int getFintas() {
        return fintas;
    }

    
    /** 
     * @param fintas
     */
    public void setFintas(int fintas) {
        this.fintas = fintas;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nPases: " + pases +
                "\nFintas: " + fintas;
    }
}
