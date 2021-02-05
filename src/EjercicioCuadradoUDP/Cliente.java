package EjercicioCuadradoUDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) 
	{

		try {
			Scanner in = new Scanner(System.in);
			DatagramSocket socketUDP = new DatagramSocket();
			InetAddress direccionIPServidor = InetAddress.getByName("localhost");
			int PUERTO = 5000;
			byte [] buffer;
			buffer = new byte [1024];
			//Gestion de la comunicacion
				//entrada
			
			System.out.println("Introduce un numero a enviar");
			String num = in.nextLine();
			buffer = num.getBytes();
			
															//Buffer, tamañoBuffer, IP, puerto
			DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, direccionIPServidor, PUERTO);
			
			System.out.println("Enviando mensaje al SERVIDOR");
			System.out.println("------------------------");
			socketUDP.send(paqueteEnviado);
			
				//Salida
			
			
			byte[] bufferRes = new byte[1024];
			DatagramPacket paqueteRecibido = new DatagramPacket(bufferRes, bufferRes.length);
			socketUDP.receive(paqueteRecibido);
			
			System.out.println("Recibiendo mensaje al SERVIDOR");
			System.out.println("------------------------");
			
			String datos = new String(paqueteRecibido.getData());
			System.out.println(datos.trim());
			
			//Cerrar la conexion
			socketUDP.close();
			in.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		

	}

}
