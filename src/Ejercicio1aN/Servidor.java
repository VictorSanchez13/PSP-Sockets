package Ejercicio1aN;

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
		int num = 0;
		
		try {
					
			System.out.println("Introduce puerto de escucha: ");
			int listenPort = in.nextInt();
			
			servidor = new ServerSocket(listenPort);
			
			System.out.println("Escuchando en el puerto " +listenPort);
			//Establecemos la comunicacion con el cliente. UN SOLO CLIENTE
			while(true) {
				sc = servidor.accept();
				System.out.println("Se ha conectado " + sc.getInetAddress() +" desde su puerto " +sc.getLocalPort());
	
				entrada = new DataInputStream(sc.getInputStream());
				
				//Leemos la respuesta
				System.out.println(entrada.readUTF());
				System.out.println("--------------------");
				//Trabajamos con el cliente
					//Gestionamos datos de entrada y salida

				if(!sc.getKeepAlive()) {
					System.out.println("Adios cliente");
				}
				sc.close();
			}
			
			
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
