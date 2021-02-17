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

		
		try {
					
			System.out.println("Introduce puerto de escucha: ");
			int listenPort = in.nextInt();
			
			servidor = new ServerSocket(listenPort);
			
			System.out.println("Escuchando en el puerto " +listenPort);
			//Establecemos la comunicacion con el cliente. UN SOLO CLIENTE
			sc = servidor.accept();
			System.out.println("Se ha conectado " + sc.getInetAddress() +" desde su puerto " +sc.getLocalPort());
			
			while (true) {
				entrada = new DataInputStream(sc.getInputStream());
				
				if(!entrada.readUTF().toLowerCase().equals("salir")) {
					System.out.println(entrada.readUTF());
	
				}else {
					System.out.println("Adios cliente");
					break;
				}
	
			} 
			 
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
