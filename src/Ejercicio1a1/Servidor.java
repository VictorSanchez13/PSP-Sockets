package Ejercicio1a1;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {
	public static void main(String[] args) {
		// Lo podemos crear como constantes
		
		ServerSocket servidor = null;
		Socket sc = null;
		Scanner in = new Scanner(System.in);
		DataInputStream entrada;	
		
		try {
					
			System.out.println("Introduce puerto de escucha: ");
			int listenPort = in.nextInt();
			
			servidor = new ServerSocket(listenPort);
			
			System.out.println("Escuchando en el puerto " +listenPort);
			//Establecemos la comunicacion con el cliente. UN SOLO CLIENTE
			sc = servidor.accept();
			
			entrada = new DataInputStream(sc.getInputStream());
			
			System.out.println("Mensajes recibidos");
			System.out.println("--------------------");
			//Trabajamos con el cliente
				//Gestionamos datos de entrada y salida
			String mensajeRecibido = entrada.readUTF();//Leemos respuesta
            System.out.println(mensajeRecibido);
			
			
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
