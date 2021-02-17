package Ejercicio1aN_BI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	final static int puerto = 5000;
	final static String ip = "127.0.0.1";

	public static void main(String[] args) {
		DataInputStream in;
		DataOutputStream out;
		Scanner sc = new Scanner(System.in);
		boolean sw = true;
		System.out.println("Introduce tu nombre de usuario");
		String nick = sc.nextLine();
		try {
			// 1) Creación del socket
			Socket soc = new Socket(ip, puerto);
			while (true) {
				Scanner inC = new Scanner(System.in);
				if(sw) {
				out = new DataOutputStream(soc.getOutputStream());
				out.writeUTF(nick);
				sw= false;
				}
				System.out.println("Introduce un mensaje para el servidor \n" + "Si desea salir escriba \"borrar\" \n"
						+ "Si desea cerrar el servidor escriba \"cerrar\"");
				String mensaje = inC.nextLine();
				if (mensaje.toLowerCase().equals("cerrar")) {
					DataOutputStream cerrar;
					cerrar = new DataOutputStream(soc.getOutputStream());
					cerrar.writeUTF(mensaje);
					inC.close();
					break;
				} else if (mensaje.toLowerCase().equals("borrar")) {
					DataOutputStream borrar;
					borrar = new DataOutputStream(soc.getOutputStream());
					borrar.writeUTF(mensaje);
					inC.close();
					break;
				} else {
					DataOutputStream normal;
					normal = new DataOutputStream(soc.getOutputStream());
					normal.writeUTF(mensaje);
					mensaje = "";
				}
				
			}
			System.out.println("Cliente cerrado");
			soc.close();
			sc.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
