package EjercicioCuadradoUDP;

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
				
				
				//Recibimos paquete del cliente
				System.out.println("Escuchando por el puerto " + PUERTO);
				System.out.println("");
				
				DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
				socketUDP.receive(paqueteRecibido);
				
				System.out.println("Recibiendo mensaje del CLIENTE");
				System.out.println("--------------------------");		
				
				String datos = new String(paqueteRecibido.getData());
				System.out.println(datos.trim());
				
				int num = Integer.parseInt(datos.trim());
				
				System.out.println(num);
				int cuadrado = num * num;	

				
				//Obtenemos el puerto del que ha enviado el paquete
				//Enviamos mensaje al cliente
				int puertoCliente = paqueteRecibido.getPort();

				InetAddress direccion = paqueteRecibido.getAddress();
	
				datos = ""+cuadrado; 
				buffer = datos.trim().getBytes();
							
				DatagramPacket paqueteEnviado = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
				socketUDP.send(paqueteEnviado);
				
				System.out.println("");
				System.out.println("Enviando mensaje al CLIENTE");
				System.out.println("---------------------------");
				System.out.println("Paquete enviado");
				
			}
		
					
			} catch (Exception e) {
				// TODO: handle exception
			} 

	}
}
