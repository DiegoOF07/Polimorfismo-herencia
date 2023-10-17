/*
 * @author: Diego Oswaldo Flores Rivas - 23714
 * @version: 16/10/23c
 * 
 * El proposito de este programa es brindar la administracion automatizada de un torneo el cual puede
 * inscribir 3 tipos de jugadores donde se pueden visualizar todas sus caracteristicas
 * 
 */


import java.util.Scanner;

public class Principal {
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Torneo tr = new Torneo();
        try{
            tr.inicialize();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        boolean continuar = true;
        boolean state = true;
        while (continuar) {
            System.out.println("\nTORNEO\n");
            System.out.println("1. Agregar jugadores");
            System.out.println("2. Mostrar a todos los jugadores");
            System.out.println("3. Mostrar los mejores 3 líberos");
            System.out.println("4. Mostrar los pasadores efectivos");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            String op = sc.nextLine();
            switch (op){
                case "1":
                    try {
                        System.out.println("\nTIPOS DE JUGADORES\n");
                        System.out.println("1. Libero");
                        System.out.println("2. Pasador");
                        System.out.println("3. Auxiliar/Opuesto");
                        System.out.print("Elige el tipo de jugador: ");
                        String tipoJugador = sc.nextLine();
                        System.out.print("Ingresa el nombre del jugador: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingresa el pais del jugador: ");
                        String pais = sc.nextLine();
                        System.out.print("Ingresa el numero de errores del jugador: ");
                        int errores = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingresa el numero de aces del jugador: ");
                        int aces = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingresa el total de servicios del jugador: ");
                        int totalServicios = sc.nextInt();
                        sc.nextLine();
                        if(tipoJugador.equals("1")){
                            System.out.print("Ingresa el numero de recibos efectivos del jugador: ");
                            int recibosEfectivos = sc.nextInt();
                            sc.nextLine();
                            state = tr.agregarJugador(tipoJugador,nombre,pais,errores,aces,totalServicios,recibosEfectivos,0,0,0,0,0);
                            if(!state){
                                System.out.println("Algunos datos no son validos\n");
                            }else{
                                System.out.println("Agregado con exito!");
                            }
                        }else if(tipoJugador.equals("2")){
                            System.out.print("Ingresa el numero de pases del jugador: ");
                            int pases = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingresa el numero de fintas del jugador: ");
                            int fintas = sc.nextInt();
                            sc.nextLine();
                            state = tr.agregarJugador(tipoJugador, nombre,pais,errores,aces,totalServicios,0,pases,fintas,0,0,0);
                            if(!state){
                                System.out.println("Algunos datos no son validos\n");
                            }else{
                                System.out.println("Agregado con exito!");
                            }
                        } else if (tipoJugador.equals("3")) {
                            System.out.print("Ingresa el numero de ataques del jugador: ");
                            int ataques = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingresa el numero de bloqueos efectivos del jugador: ");
                            int bloqueosEfec = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Ingresa el numero de bloqueos fallidos del jugador: ");
                            int bloqueosFall = sc.nextInt();
                            sc.nextLine();
                            state = tr.agregarJugador(tipoJugador, nombre,pais,errores,aces,totalServicios,0,0,0,ataques,bloqueosEfec,bloqueosFall);
                            if(!state){
                                System.out.println("Algunos datos no son validos\n");
                            }else{
                                System.out.println("Agregado con exito!");
                            }
                        }else{
                            System.out.println("El tipo de jugador que ingresaste no es valido");
                        }
                    }catch (Exception e){
                        System.out.println("Ingresaste mal algun dato");
                        sc.nextLine();
                    }
                    break;
                case "2":
                    try {
                        tr.uploadData();
                        for(int i = 0; i<tr.mostrarJugadores().size(); i++){
                            System.out.println(tr.mostrarJugadores().get(i));
                            System.out.println(tr.mostrarJugadores().get(i).efectividad()+"\n");
                        }
                    }catch (Exception e){
                        System.out.println("Ocurrio un error al mostrar a los jugadores");
                    }
                    break;
                case "3":
                    try {
                        for(int i = 0; i<tr.tresMejoresLiberos().length; i++){
                            if(tr.tresMejoresLiberos()[i]!=null){
                                System.out.println(tr.tresMejoresLiberos()[i]);
                                System.out.println(tr.tresMejoresLiberos()[i].efectividad()+"\n");
                            }
                        }
                    }catch (Exception e){
                        System.out.println("Ocurrio un error al mostrar a los 3 mejores liberos");
                    }
                    break;
                case "4":
                    try{
                        for(int i = 0; i<tr.pasadoresEfectivos().size(); i++){
                            System.out.println(tr.pasadoresEfectivos().get(i));
                            System.out.println(tr.pasadoresEfectivos().get(i).efectividad()+"\n");
                        }
                    }catch (Exception e){
                        System.out.println("Ocurrio un error al mostrar a los pasadores con mas de un 80% de efectividad");
                    }
                    break;
                case "5":
                    continuar = false;
                    try{
                        tr.uploadData();
                    }catch (Exception e) {
                        System.out.println("Sucedio un error al guardar a todos los inscritos");
                    }
                    break;
            }
        }

    }
}
