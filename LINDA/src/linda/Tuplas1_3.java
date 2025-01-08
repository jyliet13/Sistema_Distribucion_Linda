package linda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Tuplas1_3 extends Conexion { //Se hereda de conexión para hacer uso de los sockets y demás

    public Tuplas1_3() throws IOException {
    	super("tuplas1_3");
    }

    public void startServer() {//Método para iniciar el servidor
        try {
        	while(true) {
	            System.out.println("Aqui Tuplas 1 a 3"); //Esperando conexión
	            cs = ssTuplas1_3.accept(); //Accept comienza el socket y espera una conexión desde un cliente
	            System.out.println("Tupla enviada");
	
	            DataInputStream in = new DataInputStream(cs.getInputStream());
	            DataOutputStream out = new DataOutputStream(cs.getOutputStream());

				System.out.println("Este es el servidor de tuplas 1 a 3");

	            String mensaje = ("Te conectaste con el servidor de Tuplas de 1 a 3");
	            out.writeUTF(mensaje);
	            System.out.println("Fin de la conexión");
	            cs.close();//Se finaliza la conexión con el cliente
        	}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
