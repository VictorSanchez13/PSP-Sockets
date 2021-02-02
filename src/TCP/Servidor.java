package TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		// Lo podemos crear como constantes
		
		ServerSocket servidor = null;
		Socket sc = null;
		
		try {
			servidor = new ServerSocket(5000);
			//Establecemos la comunicacion con el cliente. UN SOLO CLIENTE
			sc = servidor.accept();
			
			//Trabajamos con el cliente
				//Gestionamos datos de entrada y salida
			
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
