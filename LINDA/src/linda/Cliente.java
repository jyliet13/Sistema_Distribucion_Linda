package linda;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.*;

public class Cliente extends Conexion {

    public Cliente() throws IOException {
        super("cliente");
    } //Se usa el constructor para cliente de Conexion

    public void inicio() throws IOException {
        boolean inicio = false;
        Scanner inn = new Scanner(System.in);
        do{
            System.out.println("¿Deseas conectarte al servicio?: S/N ");
            switch(inn.next()){
                case "S":
                    System.out.println("Bienvenido al servidor");
                    startClient();
                    inicio = true;
                    break;
                case "N":
                    System.out.println("Adios");
                    inicio=true;
                    cs.close();
            }
        }while(!inicio);
    }
    public void startClient() {//Método para iniciar el cliente
        try {
            // Canal para recibir mensajes (entrada)
            DataInputStream in = new DataInputStream(cs.getInputStream());
            // Canal para enviar mensajes (salida)
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());

            String[] tupla={"Alberto", "20", "Suspendido"};//Mete aqui los elementos que quieras enviar
            int tam=tupla.length;
            out.writeInt(tam);

            boolean salir=false;
            Scanner inn = new Scanner(System.in);
            do {
                System.out.println("Que quieres hacer");
                System.out.println("1.- PostNote");
                System.out.println("2.- RemoveNote");
                System.out.println("3.- ReadNotes");
                switch(inn.next()){
                    case "1":
                        System.out.println("Tupla de tamaño " + tam + " enviada -> " + Arrays.toString(tupla));
                        for (int i = 0; i < tam; i++) {
                            out.writeUTF(tupla[i]);
                        }
                        break;
                    case "2":
                        for (int i = 0; i < tam; i++) {
                            tupla[i]=in.readUTF();
                        }
                        System.out.println(Arrays.toString(tupla));
                        break;
                    case "3":
                        in.readLine();
                        break;
                }
                System.out.println("Si quieres salir pulsa: S");
                if(inn.next().equals("S")) salir=true;
                else salir=false;
            }while(!salir);

            cs.close();//Fin de la conexión
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
