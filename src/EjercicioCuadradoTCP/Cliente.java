package EjercicioCuadradoTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		// Lo podemos crear como constantes
		Scanner in = new Scanner(System.in);
		DataOutputStream salida;
		DataInputStream entrada;

		String DIRECCION = "127.0.0.1";
		int PUERTO = 5000;
		
		// 1) Creamos conexion
		Socket sc;
		System.out.println("Conectando con el servidor");
		
		try {
			//2) Hemos establecido la conexion
			sc = new Socket(DIRECCION, PUERTO);
			System.out.println("Puerto local: " + sc.getLocalPort());
			System.out.println("Puerto remoto: " + PUERTO);
			System.out.println("Host remoto: " + DIRECCION);
			
			//3) Trabajamos
				//Gestionamos datos de entrada y salida
			salida = new DataOutputStream(sc.getOutputStream());
			System.out.println("");
			System.out.println("Escribe el numero a enviar: ");
			
			int numero = in.nextInt();
			
			salida.writeByte(numero);
			
			System.out.println("Mensaje recibido desde el SERVIDOR");
			System.out.println("--------------------");
			
			entrada = new DataInputStream(sc.getInputStream());
			System.out.println(entrada.read());
			
			//4) Cerramos la conexion
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
