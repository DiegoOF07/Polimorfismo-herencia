/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * Esta clase se encarga de toda la logica de persistencia, encargandose de crear, leer y escribir los 
 * datos de los jugadores en un archivo csv para su posterior uso
 * 
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Data {
    private File archivo;

    public Data(String fileName){
        archivo = new File(fileName);
    }

    
    /** 
     * @param jugadores
     * @throws Exception
     */
    public void writeData(ArrayList<Jugador> jugadores) throws Exception{
        PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
        String linea ="";
        for (Jugador jugador:jugadores){
            linea = jugador.getNombre() + "," +jugador.getPais() + "," + jugador.getErrores() + "," + jugador.getAces() + "," + jugador.getTotalServicios() ;
            if (jugador instanceof Libero)
                linea = linea + ","+((Libero)jugador).getRecibosEfectivos()+","+ ","+ ","+ ","+ ","+ "," +"1";
            else if (jugador instanceof Pasador)
                linea = linea +","+ ","+((Pasador)jugador).getPases()+","+((Pasador)jugador).getFintas()+","+ ","+ ","+ ","+"2";
            else
                linea = linea +","+","+","+ ","+((Auxiliar)jugador).getAtaques()+","+((Auxiliar)jugador).getBloqueosEfectivos()+","+((Auxiliar)jugador).getBloqueosFallidos()+ ","+"3";
            writer.println(linea);
        }
        writer.close();
    }

    
    /** 
     * @throws Exception
     */
    public void createFile() throws Exception{
        if(!archivo.exists()) {
            PrintWriter writer = new PrintWriter(new FileWriter(archivo, true));
            String linea = "Nombre,País,Errores,Aces,TotaServicios,RecibosEfectivos,Pases,Fintas,Ataques,BloqueosEfectivos,BloqueosFallidos,TipoJugador\n";
            writer.print(linea);
            writer.close();
        }
    }

    
    /** 
     * @return ArrayList<Jugador>
     * @throws Exception
     */
    public ArrayList<Jugador> readData() throws Exception{
        ArrayList<Jugador> archivados = new ArrayList<Jugador>();
        BufferedReader bufer = new BufferedReader(new FileReader(archivo));
        String linea = bufer.readLine();
        while(linea != null){
            List<String> items = Stream.of(linea.split("\\s*,\\s*")).toList();
            if(items.get(11).equals("1")){
                archivados.add(new Libero(items.get(0),items.get(1),Integer.parseInt(items.get(2)),Integer.parseInt(items.get(3)),Integer.parseInt(items.get(4)),Integer.parseInt(items.get(5))));
            }else if(items.get(11).equals("2")){
                archivados.add(new Pasador(items.get(0),items.get(1),Integer.parseInt(items.get(2)),Integer.parseInt(items.get(3)),Integer.parseInt(items.get(4)),Integer.parseInt(items.get(6)),Integer.parseInt(items.get(7))));
            }else if(items.get(11).equals("3")){
                archivados.add(new Auxiliar(items.get(0),items.get(1),Integer.parseInt(items.get(2)),Integer.parseInt(items.get(3)),Integer.parseInt(items.get(4)),Integer.parseInt(items.get(8)),Integer.parseInt(items.get(9)),Integer.parseInt(items.get(10))));
            }
            linea = bufer.readLine();
        }
        if(linea !=null){
            bufer.close();
        }
        return archivados;
    }
}
