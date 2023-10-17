/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta es la clase padre que modela a los 3 tipos de jugadores diferentes que el 
 * programa puede admitir y almacenar
 * 
 */
public class Jugador {
    protected String nombre;
    protected String pais;
    protected int errores;
    protected int aces;
    protected int totalServicios;

    public Jugador(String nombre, String pais, int errores, int aces,  int totalServicios ){
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalServicios = totalServicios;
    }

    
    /** 
     * @return double
     */
    public double efectividad(){
        return aces*100/totalServicios;
    }

    
    /** 
     * @return String
     */
    public String getNombre() {
        return nombre;
    }

    
    /** 
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
    /** 
     * @return String
     */
    public String getPais() {
        return pais;
    }

    
    /** 
     * @param pais
     */
    public void setPais(String pais) {
        this.pais = pais;
    }

    
    /** 
     * @return int
     */
    public int getErrores() {
        return errores;
    }

    
    /** 
     * @param errores
     */
    public void setErrores(int errores) {
        this.errores = errores;
    }

    
    /** 
     * @return int
     */
    public int getAces() {
        return aces;
    }

    
    /** 
     * @param aces
     */
    public void setAces(int aces) {
        this.aces = aces;
    }

    
    /** 
     * @return int
     */
    public int getTotalServicios() {
        return totalServicios;
    }

    
    /** 
     * @param totalServicios
     */
    public void setTotalServicios(int totalServicios) {
        this.totalServicios = totalServicios;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "    Jugador" +
                "\nNombre: " + nombre+
                "\nPais: " + pais +
                "\nErrores: " + errores+
                "\nAces: " + aces +
                "\nTotal de Servicios: " + totalServicios;
    }
}
