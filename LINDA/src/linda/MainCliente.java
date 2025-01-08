package linda;

import java.io.IOException;

/**
 * avisame si es mejor este o hacer
 * otra clase para extender Thread
 * Juliet
 */

//Clase principal que hará uso del cliente
public class MainCliente {
  public static void main(String[] args)  {
    try {

        //creacion/instaciacion de hilo1
        Thread cliente = new Thread(() -> {
            try {
                //crea cliente
                Cliente persona = new Cliente();
                persona.inicio(); //ejecuta inicio de Cliente
            } catch (Exception e) {
                System.out.println(e.getMessage() + "problema en persona1");
            }
        });

        //creacion/instaciacion de hilo2

        Thread cliente2 = new Thread(() -> {
            try {
                //crea cliente
                Cliente persona = new Cliente();
                persona.inicio(); //ejecuta inicio de Cliente
            } catch (Exception e) {
                System.out.println(e.getMessage() + "problema en persona2");
            }
        });

        // inicia los hilos
        cliente.start();
        cliente2.start();

        //pa que los hilos terminen
        cliente.join();
        cliente2.join();
        System.out.println("Clientes han terminado");

    } catch (Exception e) {
        System.out.println(e.getMessage() + "problema en ClaseMain al final");
    }

  }
}