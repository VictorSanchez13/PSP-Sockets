package Ejercicio1aN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	final static int puerto = 1234;
	final static String ip = "127.0.0.1";

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		Scanner sc = new Scanner(System.in);
		try {
			// 1) Creación del socket
			Socket soc = new Socket(ip, puerto);
			while (true) {
				System.out.println("Introduce un mensaje para el servidor \n"
						+"Si desea salir escriba \"salir\" \n"
						+"Si desea cerrar el servidor escriba \"cerrar\"");
				String mensaje = sc.nextLine();
				if (mensaje.toLowerCase().equals("salir")) {
					break;
				}
				out = new DataOutputStream(soc.getOutputStream());
				out.writeUTF(mensaje);
			}
			System.out.println("Cliente cerrado");
			soc.close();
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
