package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {
	
	public static void main(String[] args) 
	{
		//Creamos el Socket UDP
		
		try {
			//Abrimos conexion
			int PUERTO = 5000;
			
			byte [] buffer;
			buffer = new byte [1024];
			while (true) {
				DatagramSocket socketUDP = new DatagramSocket(PUERTO);
				InetAddress direccionIPServidor = InetAddress.getByName("localhost");
				
				
				DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(paqueteRecibido);
				
				//Obtenemos el puerto del que ha enviado el paquete
				int puerto = paqueteRecibido.getPort();
				
				DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, direccionIPServidor, puerto);
				socketUDP.send(paqueteEnviado);
				
			}
		
					
			} catch (Exception e) {
				// TODO: handle exception
			} 

	}
}
