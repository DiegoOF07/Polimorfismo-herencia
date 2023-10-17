/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta es una clase hija de la clase Jugador y se encarga de modelar a todos los Liberos
 * 
 */
public class Libero extends Jugador{
    private int recibosEfectivos;
    public Libero(String nombre, String pais, int errores, int aces, int totalServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.recibosEfectivos = recibosEfectivos;
    }

    
    /** 
     * @return double
     */
    @Override
    public double efectividad() {
        return ((recibosEfectivos-errores)*100/(recibosEfectivos+errores))+super.efectividad();
    }

    
    /** 
     * @return int
     */
    public int getRecibosEfectivos() {
        return recibosEfectivos;
    }

    
    /** 
     * @param recibosEfectivos
     */
    public void setRecibosEfectivos(int recibosEfectivos) {
        this.recibosEfectivos = recibosEfectivos;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nRecibos Efectivos: " + recibosEfectivos;
    }
}
