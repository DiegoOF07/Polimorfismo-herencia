/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta clase es hija de la clase Jugador y se encarga de modelar a un Auxiliar/Opuesto
 * 
 */

public class Auxiliar extends Jugador{
    private int ataques;
    private int bloqueosEfectivos;
    private int bloqueosFallidos;

    public Auxiliar(String nombre, String pais, int errores, int aces, int totalServicios, int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
        super(nombre, pais, errores, aces, totalServicios);
        this.ataques = ataques;
        this.bloqueosEfectivos = bloqueosEfectivos;
        this.bloqueosFallidos = bloqueosFallidos;
    }

    
    /** 
     * @return double
     */
    @Override
    public double efectividad() {
        return ((ataques+bloqueosEfectivos-bloqueosFallidos-errores)*100/(ataques+bloqueosEfectivos+bloqueosFallidos+errores))+super.efectividad();
    }

    
    /** 
     * @return int
     */
    public int getAtaques() {
        return ataques;
    }

    
    /** 
     * @param ataques
     */
    public void setAtaques(int ataques) {
        this.ataques = ataques;
    }

    
    /** 
     * @return int
     */
    public int getBloqueosEfectivos() {
        return bloqueosEfectivos;
    }

    
    /** 
     * @param bloqueosEfectivos
     */
    public void setBloqueosEfectivos(int bloqueosEfectivos) {
        this.bloqueosEfectivos = bloqueosEfectivos;
    }

    
    /** 
     * @return int
     */
    public int getBloqueosFallidos() {
        return bloqueosFallidos;
    }

    
    /** 
     * @param bloqueosFallidos
     */
    public void setBloqueosFallidos(int bloqueosFallidos) {
        this.bloqueosFallidos = bloqueosFallidos;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return super.toString()+
                "\nAtaques: " + ataques +
                "\nBloqueosEfectivos: " + bloqueosEfectivos +
                "\nBloqueosFallidos: " + bloqueosFallidos;
    }
}
