package Ejercicio1aN;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// Lo podemos crear como constantes
		Scanner in = new Scanner(System.in);
		DataOutputStream salida;
		
		System.out.println("Introduce direccion del servidor: ");
		String DIRECCION = in.next();
		
		System.out.println("Introduce puerto del servidor: ");
		int PUERTO = in.nextInt();
		in.nextLine();
		
		// 1) Creamos conexion
		Socket sc;
		System.out.println("Conectando con el servidor");
		
		try {
			//2) Hemos establecido la conexion
			sc = new Socket(DIRECCION, PUERTO);

			//3) Trabajamos
				//Gestionamos datos de entrada y salida
			salida = new DataOutputStream(sc.getOutputStream());
			
			while (true) {
				System.out.println("Escribe mensaje a enviar: ");
				
				String mensaje = in.nextLine();
				in.next();
				salida.writeUTF(mensaje);
				
				if(mensaje.toLowerCase().equals("salir")) {
					sc.close();
					break;
				}
				
				
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
