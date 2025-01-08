package linda;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Conexion {
    private final int PUERTO = 1234; //Puerto para la conexión con ServidorLinda
    private final int PUERTO1_3 = 1235; //Puerto para la conexión de Tuplas1_3
    private final String HOST = "192.168.0.12"; //Host para la conexión
    protected ServerSocket ssl; //Socket del servidorLinda
    protected ServerSocket ssTuplas1_3; //Socket de tuplas1-3
    protected ServerSocket ssTuplas4_5; //Socket de tuplas4-5
    protected ServerSocket ssTuplas6; //Socket de tuplas6
    protected ServerSocket ssr; //Socket del servidorReplica

    protected Socket cs; //Socket del cliente
    
    public Conexion(String tipo) throws IOException {//Constructor
        if(tipo.equalsIgnoreCase("servidor")) {
            ssl = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            //cs = new Socket(); //Socket para el cliente
        }else if(tipo.equalsIgnoreCase("tuplas1_3")) {
            ssTuplas1_3 = new ServerSocket(PUERTO1_3);
        }
        else {
            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
        }
    }
}