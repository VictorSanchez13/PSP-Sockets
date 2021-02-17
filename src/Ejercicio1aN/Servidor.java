package Ejercicio1aN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor extends Thread {

	static int cont = 0;
	final static int PUERTO = 1234;
	static ServerSocket servidor = null;
	static Socket soc = null;
	public static void main(String[] args) {
		// 1)Creación del socket
		
		try {
			// 2) Asignación de puerto, de IP vamos a utilizar la nuestra
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor incializado");
			while (true)// 3)Escuchar, en este intervalor ya estamos escuchando alguna petición por
						// parte del cliente
			{
				soc = servidor.accept();
				cont++;
				
				System.out.println("Cliente "+cont+" se ha conectado");
				Thread t = new Servidor();
				t.start();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		DataInputStream in;
		DataOutputStream out;
		int aux = cont;
		try {
			while (true) {
				
				in = new DataInputStream(soc.getInputStream());
				if(in.readUTF().isEmpty()) {
					break;
				}
				String mensaje = in.readUTF();
				System.out.println("Cliente " + aux + ": " + mensaje);
				// Escritura de mensajes
				if (mensaje.toLowerCase().equals("salir")) {
					Thread.currentThread().interrupt();
				}else if (mensaje.toLowerCase().equals("cerrar")) {
					break;
				}
			}
			// Cerramos la conexion
			soc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Cliente desconectado");
	}

}