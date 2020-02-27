package STD;

import java.util.Scanner;

public class Menu {
	public static void main(String []args) {
		
		String nu;
		int efectivo, cantidad;
		int Nip;
		boolean eleccion;
		
		Registrar r = new Registrar();
		Propietario u = new Propietario();
		
		System.out.println("Hola. Bienvenido a STD, porfavor ingresa tu Cuenta bancaria y Nip");
		Scanner option = new Scanner(System.in);
		nu = option.next();
		
		Nip = option.nextInt();
		u.setNumTarjeta(nu);
		u.setNIP(Nip);
		u = r.selectPt(u);
		
		
		String numTarjeta = u.getNumTarjeta();
		if(u.getNumTarjeta().equalsIgnoreCase("990511990511")) {
			
			System.out.println("Biennvenido al registro de usuario. Porfavor ingrese los datos del nuevo Propietario");
			do {
				eleccion = false;
				
				System.out.println("Nombre completo: " );
				nu = option.next();
				u.setNombrePropietario(nu);
				
				System.out.println("Numero de tarjeta: " );
				nu = option.next();
				u.setNumTarjeta(nu);
				
				System.out.println("Nip de seguridad: " );
				Nip = option.nextInt();
				u.setNIP(Nip);
				
				System.out.println("Capital inicial de la cuenta: " );
				efectivo = option.nextInt();
				u.setFondoInicial(efectivo);
				
				r.insertaPT(u);
				System.out.println(u);
				
				
				System.out.println("¿Deseas registrar otro usuario en la plataforma STD? SI/NO");
				nu = option.next();
				
				if(nu.equalsIgnoreCase("s")) {
					eleccion = true;
					
				}
				else {
					System.out.println("Gracias esperamos verte pronto");
					
				}
			}
			while(eleccion == true);
		}
		
		else {
			System.out.println("Bienvenido " + u.getNombrePropietario());
			do {
				eleccion = false;
				
				System.out.println("¿Que movimiento deseas realizar? \n"
						+ "Capital disponible: " + u.getFondoInicial() + "\n"
						+ "1) Retiro de efectivo\n"
						+ "2) Deposito de efectivo");
				
				
				Nip = option.nextInt();				
				switch(Nip) {
				
				case 1:
					System.out.println("Cuanto efectivo deseas retirar de tu cuenta");
					cantidad = option.nextInt();
					if(u.getFondoInicial() >= cantidad) {
						
						efectivo = u.getFondoInicial() - cantidad;
						u.setFondoInicial(efectivo);
						r.updateFondos(numTarjeta, efectivo);
						System.out.println("Has retirado " + cantidad);
					}else {
						System.out.println("No cuentas con los fondos necesarios intentalo de nuevo");
					}
					break;					
				case 2:
					System.out.println("Cuanto efectivo deseas depositar");
					cantidad = option.nextInt();
					efectivo = u.getFondoInicial() + cantidad; 
					u.setFondoInicial(efectivo);
					r.updateFondos(numTarjeta, efectivo);
					System.out.println("Has depositado " + cantidad);
					break;
				}
				System.out.println("¿Deseas realizar otro movimiento? SI/NO");
				nu = option.next();
				
				if(nu.equalsIgnoreCase("s")) {
					eleccion = true;
				}else {
					System.out.println("Gracias esperamos verte pronto");
					
				}
				
		}while(eleccion == true);
	}
}
}