package EjercicioPING;

import java.net.InetAddress;
import java.util.Scanner;


public class PING {

	public static void main(String[] args) {
		try {
			
			Scanner sc = new Scanner(System.in);
			int cont = 0;
			String opt = "";
			boolean sig = true;
			InetAddress direccion;
			
			System.out.println("Introduce un número de intentos para el PING:");
			int intentos = sc.nextInt();
			int aux = intentos;
			
			System.out.println("Introduce un los milisegundos de respuesta:");
			int milis = sc.nextInt();
						
			
			do {
				System.out.println("");
				System.out.println("¿Quieres introducir un otro host?  S/N");
				opt = sc.next();
				
				if (opt.toLowerCase().equals("s")) {
					
					System.out.println("Introduce IP:");
					String ip = sc.next();
					
					for (int i = 0; i < aux; i++) {
						direccion = InetAddress.getByName(ip);
						
						if (direccion.isReachable(milis)) {
							System.out.println("Host alcanzado con exito");
							cont ++;
						}
						else {
							System.out.println("No se pudo alcanzar el host");
						}

						intentos--;
					}
					System.out.println();
					System.out.println("Paquetes enviados: " + aux);
					System.out.println("Recibidos: " + cont);
					System.out.println("Perdidos: " + (aux - cont));
					
				}
				else {
					intentos = 0;
					System.out.println("Fin del programa");
					sig = false;
				}
				
				
				
			}while(sig);
	
//			System.out.println();
//			System.out.println("Paquetes enviados: " + aux);
//			System.out.println("Recibidos: " + cont);
//			System.out.println("Perdidos: " + (aux - cont));
			
			

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
