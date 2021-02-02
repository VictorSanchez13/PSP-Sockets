package EjercicioCuadradoTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
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
		DataOutputStream salida;
		
		try {

			int listenPort = 5000;
			
			servidor = new ServerSocket(listenPort);
			
			System.out.println("Escuchando en el puerto " +listenPort);
			//Establecemos la comunicacion con el cliente. UN SOLO CLIENTE
			sc = servidor.accept();
			
			entrada = new DataInputStream(sc.getInputStream());
			
			System.out.println("");
			System.out.println("Mensajes recibidos del CLIENTE");
			System.out.println("--------------------");
			//Trabajamos con el cliente
				//Gestionamos datos de entrada y salida
			byte mensajeRecibido = entrada.readByte();//Leemos respuesta
			Byte b = new Byte (mensajeRecibido); 
            System.out.println(mensajeRecibido);
			
            
            System.out.println("Enviando mensajes al CLIENTE...");
            
            salida = new DataOutputStream(sc.getOutputStream());
            
            
            int send = b.intValue() * b.intValue();
            salida.write(send);
            
			
			sc.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
