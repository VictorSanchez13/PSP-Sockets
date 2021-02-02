package TCP;

import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		// Lo podemos crear como constantes
		
		String DIRECCION = "";
		int PUERTO = -1;
		
		// 1) Creamos conexion
		Socket sc;
		
		try {
			//2) Hemos establecido la conexion
			sc = new Socket(DIRECCION, PUERTO);
	
			//3) Trabajamos
				//Gestionamos datos de entrada y salida
			
			//4) Cerramos la conexion
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
