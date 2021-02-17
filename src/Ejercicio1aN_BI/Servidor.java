package Ejercicio1aN_BI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor extends Thread {

	static int cont = 0;
	final static int PUERTO = 5000;
	static ServerSocket servidor = null;
	static Socket soc = null;
	static String nick;
	public static void main(String[] args) {
		// 1)Creación del socket
		
		try {
			// 2) Asignación de puerto, de IP vamos a utilizar la nuestra
			servidor = new ServerSocket(PUERTO);
			System.out.println("Servidor incializado y a la espera de clientes");
			while (true)// 3)Escuchar, en este intervalor ya estamos escuchando alguna petición por
						// parte del cliente
			{
				
				soc = servidor.accept();
				DataInputStream in;
				in = new DataInputStream(soc.getInputStream());
				String paquete = in.readUTF();
				nick = paquete;
				System.out.println("El nick del cliente es: "+ nick);
				//Inicializamos el socket
				Thread t = new Servidor();
				t.start();
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		DataInputStream in;
		DataOutputStream out;
		cont++;
		try {
			while (cont!=0) {
				in = new DataInputStream(soc.getInputStream());
				if(in.readUTF().isEmpty()) {
					break;
				}
				String mensaje = in.readUTF();
				System.out.println("El cliente "+nick+" dice: "+mensaje);
				// Escritura de mensajes
				if (mensaje.toLowerCase().equals("borrar")) {
					System.out.println("El cliente "+nick+ " se va a "+mensaje);
					Thread.currentThread().interrupt();
					cont--;
					if(cont==0) {
					break;
					}
				}else if (mensaje.toLowerCase().equals("cerrar")) {
					Thread.currentThread().interrupt();
					cont--;
					if(cont==0) {
					break;
					}
				}
			}
			Thread.currentThread().interrupt();
			// Cerramos la conexion
			soc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Cliente desconectado");
	}

}