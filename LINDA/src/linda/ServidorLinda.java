package linda;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;

public class ServidorLinda extends Conexion { //Se hereda de conexión para hacer uso de los sockets y demás

    public ServidorLinda() throws IOException {
    	super("servidor");
    }

    public void startServer() {//Método para iniciar el servidor
        try {
        	while(true) {
	            System.out.println("Esperando..."); //Esperando conexión
	            cs = ssl.accept(); //Accept comienza el socket y espera una conexión desde un cliente
	            System.out.println("Cliente en línea");
	
	            DataInputStream in = new DataInputStream(cs.getInputStream());
	            DataOutputStream out = new DataOutputStream(cs.getOutputStream());

	            //Se le envía un mensaje al cliente usando su flujo de salida
	            out.writeUTF("Petición recibida y aceptada");
				Vector tupla = new Vector();
				int tam = in.readInt();

				for (int i = 0; i < tam; i++) {
					tupla.add(in.readUTF());
				}

	            System.out.println("Tupla recibida -> " + tupla);
				if (tupla.size() <= 3) {
					for (int i = 0; i < tupla.size(); i++) {
						out.writeUTF(tupla.elementAt(i).toString());
					}
				}
				else if(tupla.size() >=6) {
					for (int i = 0; i < tupla.size(); i++) {
						out.writeUTF(tupla.elementAt(i).toString());
					}
				}
				else {
					for (int i = 0; i < tupla.size(); i++) {
						out.writeUTF(tupla.elementAt(i).toString());
					}
				}

	            System.out.println("Fin de la conexión");
	            cs.close();//Se finaliza la conexión con el cliente
        	}
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
