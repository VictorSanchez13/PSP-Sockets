package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Cliente {

	public static void main(String[] args) 
	{
		//Creamos el Socket UDP
		
		try {
			//Abrimos conexion
			DatagramSocket socketUDP = new DatagramSocket();
			InetAddress direccionIPServidor = InetAddress.getByName("localhost");
			int PUERTO = -1;
			byte [] buffer;
			buffer = new byte [1024];
			//Gestion de la comunicacion
				//entrada
															//Buffer, tamañoBuffer, IP, puerto
			DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, direccionIPServidor, PUERTO);
			socketUDP.send(paqueteEnviado);
			
				//Salida
			DatagramPacket paqueteRecibido = null;
			socketUDP.receive(paqueteRecibido);
			
			//Cerrar la conexion
			socketUDP.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
		

	}

}
