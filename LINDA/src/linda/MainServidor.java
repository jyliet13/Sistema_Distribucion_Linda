package linda;

import java.io.IOException;

//Clase principal que hará uso del servidor
public class MainServidor {
  public static void main(String[] args) throws IOException {
      ServidorLinda serv = new ServidorLinda(); //Se crea el servidor
      Tuplas1_3 t = new Tuplas1_3();

      System.out.println("Iniciando servidor\n");
      serv.startServer(); //Se inicia el servidor
      t.startServer();
  }
}