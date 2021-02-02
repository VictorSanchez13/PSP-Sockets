package Innet;

import java.net.InetAddress;


public class Ejemplo {

	public static void main(String[] args) {
		try {
			InetAddress direccion = InetAddress.getLocalHost();
			System.out.println(direccion.toString());
			
			direccion = InetAddress.getByName("VICTOR-PC");
			System.out.println(direccion.getHostAddress());
			
			InetAddress direccionEnviar = InetAddress.getByName("10.11.0.103");
			
			
			
			boolean alcanzado = direccionEnviar.isReachable(1000);
			System.out.println("Tenemos acceso al host " + alcanzado);
			System.out.println("Tenemos acceso local " + direccionEnviar.isAnyLocalAddress());
			
			//IP principal de un servidor
			InetAddress direccionWeb = InetAddress.getByName("google.com");
			
			System.out.println("IP de la web: " + direccionWeb);
			
			//Todas las IP de un servidor
			InetAddress [] direccionesDeUnaWEB = InetAddress.getAllByName("yahoo.com");
			for (InetAddress direccionIt : direccionesDeUnaWEB) {
				System.out.println(direccionIt.toString());
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
